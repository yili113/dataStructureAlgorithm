package cqupt.leetCode.tree;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-05-21 16:01
 * 要求：路径是从一个结点开始向下,只选择左右结点中的一个,然后向下形成的单链
 */
public class GetMaxLen {
    public int getMaxLength(TreeNode head, int sum) {
        // 创建一个map表
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);// 表示累加和为0的时候起始层是在0层
        return preOrder(head, sum, 0, 1, 0, map);
    }

    /**
     *
     * @param head 头结点
     * @param sum 已知的路径和
     * @param preSum 父结点已有的累计和
     * @param level 当前层数
     * @param maxLen 最大路径
     * @param map
     */
    private int preOrder(TreeNode head, int sum, int preSum, int level, int maxLen,
                          HashMap<Integer, Integer> map) {
        if (head == null)
            return maxLen;
        // 计算当前结点的累计和
        int curSum = preSum + head.val;
        // 判断当前结点的累计和是否在map中
        if (!map.containsKey(curSum))
            map.put(curSum, level);
        // 判断curSum是否超过了sum
        if (map.containsKey(curSum - sum))
            // curSum - sum累加和对应的level就是sum之前的level，
            // 当前的level就是curSum - sum的level   +   sum的level
            maxLen = Math.max(maxLen, level - map.get(curSum - sum));
        // 左右子树递归
        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, map);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, map);
        if (level == map.get(curSum))
            map.remove(curSum);
        return maxLen;
    }
}
