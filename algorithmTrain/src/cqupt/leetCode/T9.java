package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-02-28 15:23
    回文数
    思路1：求该数的反转数，比较反转数和原数
    思路2：直接比较该数的首位和末位，依次移动指针持续比较
 */
public class T9 {


    public static void main(String[] args) {
        T9 t9 = new T9();
        System.out.println(t9.isPalindrome1(121));
        boolean res = t9.isPalindrome1(121);
    }

    private boolean isPalindrome1(int x) {
        if (x < 0)
            return false;
        // 找这个数是多少位的
        int div = 1;
        while (x / div >= 10)// 此处的div表示x的最高位 比如x=123 div=100
            div *= 10;
        while (x != 0) {
            // 求最左侧的数
            int left = x / div;
            // 求最右侧的数
            int right = x % 10;
            if (left != right)
                return false;// 不等则返回false
            // 将该数去掉首尾两个数
            x = (x - left * div) / 10;// x - left * div去掉第一位数  /10去掉最后一位数
            div /= 100;// 每次减少两位数 div/100
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        int oriX = x;
        if (x < 0)
            return false;
        int rev = 0;
        while (x != 0) {
            int newRev = rev * 10 + x % 10;
            rev = newRev;
            x = x / 10;
        }
        if (rev == oriX)
            return true;
        return false;
    }
}
