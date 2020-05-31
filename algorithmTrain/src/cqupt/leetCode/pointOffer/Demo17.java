package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-31 10:04
 */
public class Demo17 {
    public int[] printNumbers(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "9";
        }
        int max = Integer.parseInt(str);
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
