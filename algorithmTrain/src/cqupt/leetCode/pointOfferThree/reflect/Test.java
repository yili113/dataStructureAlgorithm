package cqupt.leetCode.pointOfferThree.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-07-22 14:55
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<TargetObject> taClass = TargetObject.class;
        TargetObject targetObject = (TargetObject) taClass.newInstance();

        // 获取类中定义的方法
        Method[] declaredMethods = taClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

        // 获取指定方法并调用
        Method publicMethod = taClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "wang");// i wang

        // 获取指定参数并对参数修改
        Field field = taClass.getDeclaredField("value");
        field.setAccessible(true);// 关闭访问检查,就可以调用private和protected修饰符修饰的字段或方法
        field.set(targetObject, "sijia");// 修改私有域

        // 调用private方法
        Method privateMethod = taClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);


        // 测试asList
        // asList方法传入的参数不能是基本类型的数组
        int[] arr = {1,2,3};
        Integer[] arrIn = {1, 2, 3};
        List<int[]> ints = Arrays.asList(arr);
        List<Integer> integers = Arrays.asList(arrIn);
        System.out.println(ints.size());// 1   基本类型的数组大小永远是1    反编译成一个一行三列的二维数组
        System.out.println(ints.get(0).length);// 3  由此可以验证是1行3列的二维数组


        System.out.println(integers.size());// 3
        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        System.out.println(integers1.size());// 3
    }
}
