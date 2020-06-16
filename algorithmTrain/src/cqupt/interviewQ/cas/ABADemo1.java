package cqupt.interviewQ.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yiLi
 * @create 2020-06-15 20:47
 */
public class ABADemo1 {
    public static void main(String[] args) {
        money.set(19);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    while (true) {
                        Integer m = money.get();
                        if (m < 20) {
                            if (money.compareAndSet(m,m + 20)) {
                                System.out.println("余额小于20，充值成功，余额：" + money.get());
                                break;
                            }
                        }else {
                            System.out.println("余额大于20，无需充值");
                            break;
                        }
                    }
                }
            }).start();
        }
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                while (true) {
                    Integer m = money.get();
                    if (m > 10) {
                        System.out.println("大于10元");
                        if (money.compareAndSet(m,m - 10)) {
                            System.out.println("余额消费10元，余额：" + money.get());
                            break;
                        }
                    }else {
                        System.out.println("没有足够的金额");
                        break;
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    private static AtomicReference<Integer> money = new AtomicReference<>();
}
