package cqupt.leetCode.tree;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-05-24 15:18
 */
public class GetPostArr {
    static int[] postArr = null;
    public static int[] getPostArr(int[] preArr, int[] inArr) {
        if (preArr.length == 0 || inArr.length == 0)
            return new int[]{};
        postArr = new int[preArr.length];
        return getPost(preArr, inArr, postArr);
    }

    private static int[] getPost(int[] preArr, int[] inArr, int[] postArr) {
        // postArr = new int[preArr.length];
        int head = preArr[0];
        int index = -1;
        for (int i = 0; i < inArr.length; i++) {
            if (inArr[i] == preArr[0]) {
                index = i;
                break;
            }
        }
        //赋值
        postArr[postArr.length - 1] = preArr[0];
        // 左
        getPost(Arrays.copyOfRange(preArr, 1, index + 1),
                Arrays.copyOfRange(inArr, 0, index),
                Arrays.copyOfRange(postArr, 0, index));
        getPost(Arrays.copyOfRange(preArr, index + 1, preArr.length),
                Arrays.copyOfRange(inArr, index + 1, inArr.length),
                Arrays.copyOfRange(postArr, index, postArr.length - 1));
        return postArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getPostArr(new int[]{3, 9, 20, 15, 7},
                new int[] {9, 3, 15, 20, 7})));
    }
}
