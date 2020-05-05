package cqupt.leetCode.binaryCase;

/**
 * @author Liyi
 * @create 2020-04-29 20:45
 * 山脉数组中查找目标值
 */
public class T1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 通过二分找峰值, 请记住了！
        // 找山峰的下标
        int left = 0;
        int right = mountainArr.length() - 1;
        int peakIndex;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid - 1))
                left = mid;
            else
                right = mid;
        }
        // 出了上述while循环后,肯定剩两个元素
        if (mountainArr.get(left) >= mountainArr.get(right))
            peakIndex = left;
        else
            peakIndex = right;
        // 从山峰分开,分成两个数组进行二分查找,如果从左侧数组找到target就直接返回该下标,左侧没有再返回右侧的,都没找到就返回-1
        // 找左侧
        int idx1 = binSearch1(mountainArr, 0, peakIndex, target, true);
        if (idx1 != -1)
            return idx1;
        int idx2 = binSearch1(mountainArr, peakIndex + 1, mountainArr.length() - 1, target, false);
        return idx2;
    }

    private int binSearch1(MountainArray mountainArr, int left, int right, int target, boolean flag) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (mountainArr.get(mid) > target) {
                if (flag)
                    right = mid;
                else
                    left = mid;
            }
            else {
                if (flag)
                    left = mid;
                else
                    right = mid;
            }
        }
        if (mountainArr.get(left) == target)
            return left;
        else if (mountainArr.get(right) == target)
            return right;
        else
            return -1;
    }

    private int binSearch2(MountainArray mountainArr, int left, int right, int target) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (mountainArr.get(mid) > target)
                left = mid;
            else
                right = mid;
        }
        if (mountainArr.get(left) == target)
            return left;
        else if (mountainArr.get(right) == target)
            return right;
        else
            return -1;
    }
}



interface MountainArray {
    int get(int index);
    int length();

}