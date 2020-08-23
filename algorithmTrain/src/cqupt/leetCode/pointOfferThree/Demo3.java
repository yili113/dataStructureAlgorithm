package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-18 11:53
 */
public class Demo3 {
    public static int findRepeatNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == i)
//                continue;
//            if (nums[i] == nums[nums[i]])
//                return nums[i];
//            while (nums[i] != i) {
//                int temp = nums[i];
//                nums[i] = nums[temp];
//                nums[temp] = temp;
//            }
//        }
//        return -1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index) {
                index ++;
                continue;
            }
            if (nums[index] == nums[nums[index]])
                return nums[index];
            int temp = nums[index];
            nums[index] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
    void test() {

    }
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2,3,1,0,2,5,3}));
    }
}
