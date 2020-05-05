package cqupt.interviewQ.interview_volatile;

/**
 * @author Liyi
 * @create 2020-05-04 8:43
 */
public class Demo1 {

    int a = 0;
    boolean flag = false;

    public void method1() {
        a = 1;// 语句1
        flag = true;// 语句2
    }
    public void method2() {
        if (flag) {
            a = a + 5;// 语句3
        }
    }
}
