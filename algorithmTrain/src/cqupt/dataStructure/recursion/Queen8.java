package cqupt.dataStructure.recursion;

/**
 * @author yiLi
 * @create 2019-12-29 10:52
 */
public class Queen8 {
    private static int JUDE_COUNT = 0;
    static int max = 4;
    static int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d次成功放置", count);
        System.out.printf("一共测试了%d次", JUDE_COUNT);
    }

    /**
     * 放皇后并且统计次数
     * 开始是从第一个皇后开始放置 也就是n=0开始
     *
     * 示例：假设从第一个开始放 n=0时，在for循环中假设都是第一列就可以放，那么到n=8时候的那个栈空间，就会到n==max，
     * 然后就会return,出第八个栈空间，在第七个栈空间时i++。也就是说第八个是在第二列放置，又，开辟了第八个栈空间
     * @param n
     */
    private void check(int n) {
        if (n == max) {// n==8表示放第九个 能放第九个的前提是前八个已经放好了
            print();
            return;
        }
        // n表示行  i表示列
        for (int i = 0; i < max; i++) {// 此处遍历的是每一列 每一列都要试一下 才能达到回溯的效果
            // 这行代码是表示  第n个皇后放在i列看行不行 先放着 再去判断
            arr[n] = i;// 先放第n个皇后在第i列 i是遍历的 所以第n个皇后是每一列都放置了
            if (judge(n)) {// 如果第n个能放 则开始放n+1个
                check(n + 1);
            }
        }
    }
    /**
     * 判断第n个是否能放 n是从0开始的
     * 第n个是否能放 要与前n-1个比较
     * @param n
     * @return
     */
    private boolean judge(int n) {
        JUDE_COUNT ++;
        for (int i = 0; i < n; i++) {// 第n个与前n-1个依次比较
            // 判断是否在同一列或者在同一斜线上
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;// 如果能通过for循环就表示可以放置
    }
    /**
     * 当是正确解法时打印结果
     */
    private void print() {
        count++;// 正确解法统计
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
