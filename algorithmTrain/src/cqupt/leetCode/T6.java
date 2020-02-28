package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-02-28 11:13
 * 第六题
 */
public class T6 {

    /**
     * 自己的思路：如果4行就是6个字符为一组,推出如果n行就是2*n-2个字符为一组
     * 这样就有(s.length  / 2*n-2）+1组。把每一组都放在一个数组中，先遍历每组的第一个元素（第一行）
     * 然后遍历 a[1]和a[length-1](第二行)，a[2]和a[length-2](第三行)...直到遍历n行结束，期间边遍历
     * 边打印即可。如果某组中某下标位置上没元素就不打印。
     *
     * 别人思路：有多少行就new多少个StrinBuilder出来。依次遍历字符串的每个字符
     * 当是竖着形式的时候就从sb[0]到sb[len-1]存，斜着形式的时候就从sb[len-2]到sb[1]存
     * 每次存的时候就是append的过程。最终打印的时候也是把sb[1]后面的都append到sb[0]上
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 每行都要new一个StringBuilder'
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();// 此处一定要new对象，后面才能用
        }
        int index = 0;// 指向chars[]的下标
        while (index < len) {
            // 先将竖着形式的存到Builder
            for (int i = 0; i < numRows && index < len; i++) {
                sb[i].append(chars[index]);// 将第一行的字符放到sb[0]中
                index ++;
            }
            // 再将斜着形式的存到Builder
            for (int i = numRows - 2; i > 0 && index < len ; i--) {// 从倒数第二行开始，在正数第二行结束
                sb[i].append(chars[index]);
                index ++;
            }
        }
        // 此时已经按照不同行对应不同的StringBuilder存放好了
        // 输出
        // 将第二行开始的字符全部接到第一行上面
        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
