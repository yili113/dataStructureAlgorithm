package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-29 15:31
 */
public class Demo05 {

    public static String replaceSpace(String s) {
//        return s.replace(" ", "%20");
        String str = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                str += "%20";
            else
                str += chars[i];
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "you are kkk";
        System.out.println(replaceSpace(str));
    }
}
