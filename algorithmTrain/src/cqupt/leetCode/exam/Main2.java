package cqupt.leetCode.exam;

import java.util.*;

/**
 * @author yiLi
 * @create 2020-08-08 14:55
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Integer> preList = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> numList = new LinkedList<>();
        int[] nums = new int[m];
        int index = 0;
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            index ++;
            preList.add(nums[i]);
            set.add(nums[i]);
        }
        sc.close();
        for (int i = 1; i <= n; i++) {
            if (numList.size() == n - index)
                break;
            if (!set.contains(i))
                numList.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!preList.isEmpty() && !numList.isEmpty()) {
            if (preList.peek() < numList.peek())
                ans.add(preList.poll());
            else
                ans.add(numList.poll());
        }
        if (!preList.isEmpty())
            ans.addAll(preList);
        else
            ans.addAll(numList);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
