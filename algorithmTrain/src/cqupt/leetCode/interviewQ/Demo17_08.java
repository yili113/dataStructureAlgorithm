package cqupt.leetCode.interviewQ;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yiLi
 * @create 2020-06-21 15:53
 */
public class Demo17_08 {
    // height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        Com com = new Com();
        PriorityQueue pq = new PriorityQueue(com);
        for (int i = 0; i < n; i++) {
            Person person = new Person(height[i], weight[i]);
            pq.add(person);
        }
        int[] w = new int[n];
        int index = 0;
        while (!pq.isEmpty()) {
            Person cur = (Person)pq.poll();
            w[index ++] = cur.weight;
        }
        return findNumberOfLIS(w);
    }
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;// 初始化为1
        }
        int maxDp = 0;
        for (int i = 1; i < n; i++) {
            maxDp = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxDp = dp[j] > maxDp ? dp[j] : maxDp;
                }
            }
            dp[i] = maxDp + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}
class Person  {
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}
// 讲人按照身高顺序排进去
class Com implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.height - o2.height;
    }
}
