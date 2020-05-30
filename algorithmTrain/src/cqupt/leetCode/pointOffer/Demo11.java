package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-30 9:26
 * 旋转数组的最小数字
 */
public class Demo11 {

    // 垃圾复杂度 O(N)
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return 0;
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            if (numbers[i + 1] < numbers[i])
                return numbers[i + 1];
        }
        return numbers[0];
    }

    public int minArray1(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] > numbers[r])// mid指向的值在左序列中 说明旋转点还在mid和r之间
                l = mid + 1;
            else if (numbers[mid] < numbers[r])
                r = mid;
            else
                r --;
        }
        return numbers[l];
    }
}
