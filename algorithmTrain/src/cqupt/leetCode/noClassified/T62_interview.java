package cqupt.leetCode.noClassified;

import java.util.ArrayList;

/**
 * @author Liyi
 * @create 2020-03-30 10:17
 */
public class T62_interview {

    /**
     *
     * @param n
     * @param m 从0开始数删除第m个数  就是下标为 m-1的位置
     * @return
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;// 起始位置为0
        while (n > 1) {
            /**
             * 删除了idx位置上的数后,是从idx算作第一个数开始继续计算的,而不是又从0当做第一个数开始计算
             */
            idx = (idx + m - 1) % n;// 要删除第m个数就是m-1下标位置的数
            list.remove(idx);
            n --;// 每次删掉一个数长度-1
        }
        return list.get(0);
    }
}
