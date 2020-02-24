package cqupt.algorithm.hanoitower;

/**
 * @author Liyi
 * @create 2020-02-24 11:39
 * 分治算法案例 汉诺塔
 */
public class Hanoitower {
    /**
     * 1.把上面的盘从A移动到B
     * 2.把下面的盘从A移动到C
     * 3.把B上的盘移动到C
     */
    public static void main(String[] args) {
        hanoitower(2, 'A', 'B', 'C');
    }

    /**
     *
     * @param num 需要移动的盘子个数
     * @param a 起始塔
     * @param b 中间塔
     * @param c 目标塔
     */
    private static void hanoitower(int num, char a, char b, char c) {
        // 如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "-->" + c);
        }else {
            // 如果盘子数大于1的时候 总可以看作是 1.最下边一个盘子2.上面的所有盘
            // 1.先把上面的所有盘移动到B 过程中用到C
            hanoitower(num - 1, a, c, b);
            // 2.把最下面的盘从A到C
            System.out.println("第"+num+"个盘从 " + a + "-->" + c);
            // 3.把B塔上的所有盘从 B到C 移动过程中借用到A
            hanoitower(num - 1, b, a, c);
        }
    }
}
