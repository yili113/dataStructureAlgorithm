package cqupt.leetCode.noClassified;

/**
 * @author Liyi
 * @create 2020-04-03 11:13
 * 字符串转成数字
 * 对数组每个下标元素进行条件判断时，都要判断一下当前下标是否已经越界
 */
public class T8 {
    public int myAtoi(String str) {
        int res = 0;
        if (str == null || str.length() == 0)
            return res;
        int len = str.length();
        char[] chars = str.toCharArray();
        // 判断空格
        int idx = 0;
        while (idx < len && chars[idx] ==  ' ') {
            idx ++;
        }
        // 判断正负号
        boolean isNegative = false;
        if(idx < len && chars[idx] == '-') {
            isNegative = true;
            idx ++;
        }
        else if (idx < len && chars[idx] == '+')
            idx ++;
        else if (idx < len && !Character.isDigit(chars[idx]))
            return 0;
        while (idx < len && Character.isDigit(chars[idx])) {
            int curDig = chars[idx] - '0';
            // 判断是否越界
            if (res > (Integer.MAX_VALUE - curDig) / 10)// 此时已越界
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + curDig;
            idx ++;
        }
        return isNegative ? -res : res;
    }
}
