package cqupt.leetCode.noClassified;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-07 10:20
 * 合并间隔
 */
public class T56 {
    public static int[][] merge(int[][] intervals) {
        // 定义结果数组
//        int[][] res = new int[intervals.length][2];
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];
        /**
         * 把所有的start  end 放在一起
         */
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        // 将start和end排序
        /**
         * 最关键的地方就是对start和end排序
         * 假设有[3,6] [2,8]    排序之后是  [2, 6][3, 8]
         * 不管排序前后重叠的部分都是start和end中最小的那两个数构成的范围
         */
        Arrays.sort(start);
        Arrays.sort(end);
        int index  = 0;
        while(index < intervals.length) {
            int st = start[index];
            // 判断下一个start和当前的end大小
            while(index < intervals.length - 1 && end[index] >= start[index + 1]) {
                index ++;// 不断得找重叠的区间
            }
            int en = end[index];// 找到了满足的end
            /*res[index][0] = st;
            res[index][1] = en;*/
            ArrayList<Integer> curList = new ArrayList<>();
            curList.add(st);
            curList.add(en);
            lists.add(curList);
            index ++;// 新加进满足要求得interval之后  index要指向下一个位置
        }

/*        // 将res中的0元素去除
        int count = 0;
//        if (res[0][0] == 0 && res[0][1] == 0)
        for (int i = 1; i < res.length; i++) {// 排除[0, 0]情况
            if (res[i][0] == 0 && res[i][1] == 0)
                count++;
        }
        int[][] newRes = new int[res.length - count][2];
        int cur = 0;
        if (res[0][0] == 0 && res[0][1] == 0) {
            newRes[0][0] = 0;
            newRes[0][1] = 0;
            cur ++;
        }
        for (int i = 0; i < res.length; i++) {
            if (!(res[i][0] == 0 && res[i][1] == 0)) {
                newRes[cur][0] = res[i][0];
                newRes[cur][1] = res[i][1];
                cur++;
            }
        }*/
//        System.out.println(lists);
        int[][] res = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            res[i][0] = lists.get(i).get(0);
            res[i][1] = lists.get(i).get(1);
        }
         return res;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {4, 7}, {6, 9}, {8, 10}};
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 4}, {0, 0}};
        int[][] merge = merge(intervals);
        for(int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

