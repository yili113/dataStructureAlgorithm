package cqupt.writtenExamination.weiMeng;

/**
 * @author yiLi
 * @create 2020-09-06 16:05
 */
public class Main1 {
    public long sum (long n) {
        // write code here
        res = 0;
        boolean flag = n > 1 && sum(n - 1) > 0;
        res += n;
        return res;
    }
    long  res;
}
