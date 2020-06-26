package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 15:00
 * 表示数值的字符串
 */
public class Demo20 {
    public boolean isNumber(String s) {
        if (s.endsWith("d") || s.endsWith("f") || s.endsWith("D") || s.endsWith("F"))
            return false;
        try {
            Double.parseDouble(s);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
