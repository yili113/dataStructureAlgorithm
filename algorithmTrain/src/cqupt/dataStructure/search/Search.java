package cqupt.dataStructure.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 查找
 * @author yiLi
 * @create 2019-12-30 22:10
 */
public class Search {
    public static void main(String[] args) {
//        int[] arr = {12, 13, 14, 14, 14, 15, 16};
//        int result = binarySearch(arr, 0, arr.length - 1, 10);
//        System.out.println(result);
//        ArrayList<Integer> resultList = binarySearchList(arr, 0, arr.length - 1, 14);
//        System.out.println(resultList);
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        int result = insertValueSearch(arr, 0, arr.length - 1, 88);
        System.out.println(result);
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param key
     * @return
     */
    private static int insertValueSearch(int[] arr, int left, int right, int key) {
        if (left > right || key > arr[arr.length - 1] || key < arr[0]) {
            return -1;
        }
        // 求mid关键
        int mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (key > midVal) {// 说明在右边
            return binarySearch(arr, mid + 1, right, key);
        }else if (key < midVal) {
            return binarySearch(arr, left, mid - 1, key);
        }else {
            return mid;
        }
    }

    /**
     * 查找有重复元素的数组
     * @param arr
     * @param left
     * @param right
     * @param key 待查找的元素
     * @return
     */
    private static ArrayList<Integer> binarySearchList(int[] arr, int left, int right, int key) {
        // 找不到的情况
        if (left > right) {
            return new ArrayList<>();// 找不到就返回一个空的list
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (key > midVal) {// 说明在右边
            return binarySearchList(arr, mid + 1, right, key);
        }else if (key < midVal) {
            return binarySearchList(arr, left, mid - 1, key);
        }else {
            ArrayList<Integer> indexList = new ArrayList<>();
            // 能到这个地方就说明 mid就是需要的索引 但是不急返回 往左往右看看还有没有重复的  因为是有序的数组 肯定挨着的
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != key) {// 保证temp不越界并且mid左侧有重复元素
                    break;
                }
                // 没有break的话就说明有重复元素
                indexList.add(temp);
                temp -= 1;
            }
            // 记得把原本的mid放进list
            indexList.add(mid);
            // 向右
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != key) {// 保证temp不越界并且mid左侧有重复元素
                    break;
                }
                // 没有break的话就说明有重复元素
                indexList.add(temp);
                temp += 1;
            }
            return indexList;
        }
    }

    /**
     * 二分查找
     * 前提：数组必须有序
     * @param arr
     * @param left
     * @param right
     * @param key
     */
    private static int binarySearch(int[] arr, int left, int right, int key) {
        // 找不到的情况
        if (left > right) {
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (key > midVal) {// 说明在右边
            return binarySearch(arr, mid + 1, right, key);
        }else if (key < midVal) {
            return binarySearch(arr, left, mid - 1, key);// 这个right的索引是mid还是mid-1有区别 很大
            // 如果向左递归是binarySearch(arr, left, mid, key)，并且查找的是数组中最小元素左边的数（数组中没有的）
            // 那么到最后会一直剩数组最左侧的数一直进行递归 死递归  例如是 索引0到索引0！！！
            // 向右递归写错了同理
        }else {
            return mid;
        }
    }
}
