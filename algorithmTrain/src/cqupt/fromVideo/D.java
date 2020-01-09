package cqupt.fromVideo;

/**
 * @author yiLi
 * @create 2019-09-26 9:39
 */
public class D {
/*    static int x = 10;
    static  {x += 5;}*/
    String str = new String("dahua");
    char[] ch = {'a', 'b', 'c'};
    public static void main(String[] args) {
        /*System.out.println("X=" + x);*/
        D d = new D();
        d.change(d.str, d.ch);
/*        System.out.print(d.str + "and");
        System.out.println(d.ch);*/
    double x = 34.4;


    }
    /*static  {x /= 3;}*/
    public void change(String str, char ch[]) {
        str = "test success";
        ch[0] = 'g';
    }
}
