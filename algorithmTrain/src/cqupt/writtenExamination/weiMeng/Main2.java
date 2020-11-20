package cqupt.writtenExamination.weiMeng;

/**
 * @author yiLi
 * @create 2020-09-06 16:11
 */
public class Main2 {
    public String reverseWord (String str) {
        // write code here
        str = str.trim();
        int j = str.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while (i >= 0 && str.charAt(i) != ' ')
                i --;
            res.append(str.substring(i + 1, j + 1) + " ");
            while (i >= 0 && str.charAt(i) == ' ')
                i --;
            j = i;
        }
        return res.toString().trim();
    }
}
