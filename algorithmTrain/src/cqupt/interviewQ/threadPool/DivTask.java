package cqupt.interviewQ.threadPool;

/**
 * @author yiLi
 * @create 2020-06-09 21:02
 */
public class DivTask implements Runnable {
    int a, b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a / b;
        System.out.println(re);
    }
}
