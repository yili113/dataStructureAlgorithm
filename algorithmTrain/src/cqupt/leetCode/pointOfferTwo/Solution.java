package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-12 17:19
 */
public class Solution {
    // 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    // 每一列都按照从上到下递增的顺序排序。
    // 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0)
            return false;
        int m = 0;
        int n = array[0].length - 1;
        while (m < array.length && n >= 0) {
            if (array[m][n] == target)
                return true;
            else if (array[m][n] > target)
                n --;
            else if (array[m][n] < target)
                m ++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
    public static int test() {
        int num = 5;
        try {
            int i = 10 / 0;
        }catch (Exception e) {
            num = 10;
        }finally {
            num = 15;
        }
        return num;
    }
}
