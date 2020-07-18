package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-18 13:21
 * 旋转数组的最小数字----递增排序的数组
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Demo11 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right])
                left = mid + 1;
            else if (numbers[mid] < numbers[right])
                right = mid;// 左闭右开就是这样的右移
            else if (numbers[mid] == numbers[right])
                right --;
        }
        return numbers[left];
    }
}
