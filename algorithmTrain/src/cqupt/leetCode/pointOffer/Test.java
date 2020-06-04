package cqupt.leetCode.pointOffer;

import java.util.concurrent.TimeUnit;

/**
 * @author yiLi
 * @create 2020-06-03 9:32
 */
public class Test {
    static int a = 0;
    static boolean flag = false;
    static int i ;
    public static void main(String[] args) {
        new Thread(() -> {
            a = 1;
            flag = true;
        }, "t1").start();
        new Thread(() -> {
            if (flag)
                i = a + 1;
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
