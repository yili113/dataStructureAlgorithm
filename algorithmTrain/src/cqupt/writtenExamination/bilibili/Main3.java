package cqupt.writtenExamination.bilibili;

import java.util.ArrayList;

/**
 * @author yiLi
 * @create 2020-09-04 19:03
 */
public class Main3 {
    public static int GetFragment (String str) {
        // write code here
        if (str == null || str.length() == 0)
            return 0;
        ArrayList<Integer> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        int len = chars.length;
        int left = 0;
        int right = 0;
        while (right < chars.length - 1) {
            if (chars[right + 1] != chars[right]) {
                res.add(right - left + 1);
                left = right + 1;
            }
            right ++;
        }
        int sum = 0;
        if (chars[len - 1] == chars[len - 2]) {
            res.set(res.size() - 1, res.get(res.size() - 1) + 1);
        }else {
            res.add(1);
        }
        for (Integer num : res)
            sum += num;
//        return sum / res.size();

        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1))
                count ++;
        }
        return str.length() / count;
    }

    public static void main(String[] args) {
        String s = "aaabbaaac";
        System.out.println(GetFragment(s));
    }
}
