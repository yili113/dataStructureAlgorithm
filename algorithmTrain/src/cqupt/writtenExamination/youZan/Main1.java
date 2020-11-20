package cqupt.writtenExamination.youZan;

/**
 * @author yiLi
 * @create 2020-09-11 15:16
 */
public class Main1 {
    public long sum (int num, int itemNum) {
        // write code here
        long res = 0;
        long[] temp = new long[itemNum + 1];
        temp[1] = num;
        for (int i = 2; i <= itemNum; i++) {
            temp[i] = num + temp[i - 1] * 10;
        }
        for(long n : temp)
            res += n;
        return res;
    }
}
