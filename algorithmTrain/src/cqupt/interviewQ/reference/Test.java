package cqupt.interviewQ.reference;

/**
 * @author yiLi
 * @create 2020-07-29 17:00
 */
public class Test {
    public static void main(String[] args) {
        int p = 2;
        int q = 3;
        int a = 4;
        int b = 5;
        int A = q ^ a % p;
        int B = q ^ b % p;
        System.out.println("A=" + A);
        System.out.println("B=" + B);
        int k1 = B ^ a % p;
        int k2 = A ^ b % p;
        System.out.println("k1=" + k1);
        System.out.println("k2=" + k2);
    }
}
