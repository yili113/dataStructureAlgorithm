package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-12 9:22
 * 删除数组中的重复元素
 * 允许一个元素最多两次重复
 */
public class T80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        int realLocation = 2;// realLocation下标之前的值都是有效的
        for (int idx = 2; idx < nums.length; idx++) {// 遍历也是从第三个元素开始
            // 当前面有两个数相等并且idx的元素等于realLocation-1的元素  这时候idx指的元素就不能要
            // 不考虑realLocation指向的元素 当前轮realLocation指向的元素已经被idx给遍历过了  已经判断过了
            // 就是为了判断idx指向的元素是否有效
            if (!(nums[realLocation - 1] == nums[realLocation - 2] && nums[idx] == nums[realLocation - 1])) {
                nums[realLocation] = nums[idx];// 当idx指向元素有效时进行这步操作
                realLocation ++;
            }
            // 遇到情况就只有idx++
            // 没有情况时候 idx和realLocation均++  且不断交换
        }
        return realLocation;
    }
}
