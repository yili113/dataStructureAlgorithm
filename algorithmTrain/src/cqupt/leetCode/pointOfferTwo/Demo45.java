package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author yiLi
 * @create 2020-07-02 8:43
 * 把数组排成最小的数
 */
public class Demo45 {
    // 输入: [3,30,34,5,9]
    // 输出: "3033459"
    public String minNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i] + "");
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String x = o1 + o2;
                String y = o2 + o1;
                return x.compareTo(y);// 要是3和30组合就是 303<330
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : list)
            sb.append(str);
        return sb.toString();
    }
}
