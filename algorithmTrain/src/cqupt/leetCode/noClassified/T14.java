package cqupt.leetCode.noClassified;

/**
 * @author Liyi
 * @create 2020-03-25 16:39
 * 最长公共前缀
 */
public class T14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        String ans=strs[0];
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<minLen){
                minLen=strs[i].length();
            }
        }
        for(int i=1;i<strs.length;i++){
            int j=0;
            for(;j<ans.length() && j<minLen;j++){
                if(ans.charAt(j)!= strs[i].charAt(j)){
                    break;
                }
            }
            ans=ans.substring(0,j);
            if(ans.equals(""))return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {""};
        System.out.println(longestCommonPrefix(strs));
    }
}
