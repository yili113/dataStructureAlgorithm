package cqupt.interviewQ.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-05-08 10:19
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);
        System.out.println(o1);// java.lang.Object@1b6d3586
        System.out.println(phantomReference.get());// 任何适合虚引用的get方法都是返回null
        System.out.println(referenceQueue.poll());// 在gc发生之前引用队列是空的  null

        System.out.println("发生gc之后");
        o1 = null;
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o1);// null
        System.out.println(phantomReference.get());// 任何适合虚引用的get方法都是返回null
        System.out.println(referenceQueue.poll());// 在gc之后引用队列有值 java.lang.ref.PhantomReference@4554617c
        // gc之后引用队列有值,就可以通过引用队列中这个值进行一些后续操作,类似于后置处理器
    }
}
