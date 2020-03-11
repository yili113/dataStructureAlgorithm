package cqupt.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-10 8:49
 * 子集  nums中没有重复元素
 *  * 递归+回溯
 */
public class T78 {

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        helper2(nums, 0, res, new LinkedList<Integer>());
        return res;
    }
    /**
     * 思路二：
     * 对每个元素进行遍历，每个元素都有两种选择  选/不选
     */
    private void helper2(int[] nums, int index, ArrayList<List<Integer>> res, LinkedList<Integer> curList) {
        if (index == nums.length) {// 递归出口 把数组遍历完了 只有if和else
            res.add(new LinkedList<>(curList));
        }else {
            // 还没遍历完时有两种情况
            // 1.不选当前元素(index指向的元素)
            helper2(nums, index + 1, res, curList);
            // 2.选当前元素
            curList.add(nums[index]);
            helper2(nums, index + 1, res, curList);
            curList.remove(curList.size() - 1);
        }
    }
    /**
     * 思路一：例如[1, 2, 3] 先把当前new出来的空字符放进结果集中
     * 然后选一个数时候 可以选1/2/3  当选了1之后再选只能选1后面的数  可以选成12/13
     * 3后面没有数所以后面没得选了
     * 每个组成的字符都是有效的，都要加进结果集中
     */
    private void helper1(int[] nums, int index, ArrayList<List<Integer>> res, LinkedList<Integer> curList) {
        // 只要进一层循环当前的字符串就是有效的，就要加进结果集中
//        res.add(curList);
        res.add(new LinkedList<>(curList));// 此处一定要新的集合把curList构造出来 不能改变当前curList的值 递归的其它层还要用
        for (int i = index; i < nums.length; i++) {// 用index和for来设置递归的出口
            curList.addLast(nums[i]);
            helper1(nums, i + 1, res, curList);
            curList.remove(curList.size() - 1);// 回溯
        }
    }


}
