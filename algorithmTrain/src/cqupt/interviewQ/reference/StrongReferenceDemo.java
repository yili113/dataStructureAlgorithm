package cqupt.interviewQ.reference;

import java.lang.ref.SoftReference;

/**
 * @author Liyi
 * @create 2020-05-07 16:31
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;
        obj1 = null;
        System.gc();
        System.out.println(obj2);// output:java.lang.Object@1b6d3586

        SoftReference softReference = new SoftReference(obj1);
    }
}
