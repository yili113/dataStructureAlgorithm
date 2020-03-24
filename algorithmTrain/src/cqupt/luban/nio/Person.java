package cqupt.luban.nio;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Liyi
 * @create 2020-03-07 16:57
 */
public class Person {
    int i;
    public static Unsafe UNSAFE = null;
    public static long I_OFFSET;

    public static void main(String[] args) {
        Person person = new Person();
        try {
//            UNSAFE = Person.UNSAFE.getUnsafe();
            Field field = Unsafe.class.getDeclaredField("theUnsafe");// 固定写法
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            I_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("i"));// 属性i相对于person对象的偏移量
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        // 开启一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    person.i ++;// 不能应对并发
                    /**
                     * CAS是原子操作，直接针对于操作系统
                     *
                     * param1:针对哪个对象进行cas
                     * param2:对象对应的属性
                     * 将param3改成param4
                     * return:判断是否修改成功
                     *
                     * param3是预期的值(机器内存)，进行修改时判断当前的值(当前线程内存的值)是否跟预期的值相等
                     * 相等的话就把线程内存中的值给修改了
                     */
                    boolean b = Person.UNSAFE.compareAndSwapInt(person, I_OFFSET, person.i, person.i + 1);

                    if (b)
                        System.out.println(UNSAFE.getIntVolatile(person, I_OFFSET));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        // 开启另一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    person.i ++;
                    boolean b = Person.UNSAFE.compareAndSwapInt(person, I_OFFSET, person.i, person.i + 1);
                    if (b)
                        System.out.println(UNSAFE.getIntVolatile(person, I_OFFSET));// 读取也要用到UNSAFE的方法
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
