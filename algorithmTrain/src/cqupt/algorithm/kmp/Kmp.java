package cqupt.algorithm.kmp;

/**
 * @author Liyi
 * @create 2020-02-24 15:49
 * j == -1 || t[i] == t[j] 这个判断的先后顺序不能反了 不然会出现越界异常
 */
public class Kmp {
    /**
     * 发生不匹配的时候，就从不匹配的位置往前找，找模式串的最大公共前后缀
     * 直接把模式串前缀的位置移动到后缀的位置。原理是：发生不匹配的时候，
     * 模式串的后缀肯定是和目标串是一致的，因为既然在此处发生不匹配，那么
     * 前面的肯定是匹配的。所以把公共前缀移动到后缀的位置，就行了
     * 所以需要找到最大的公共前后缀，这样才能效率最高
     */
    public static void main(String[] args) {
//        System.out.println(kmpMatch("abcabaabaabcacb", "abaabcac"));
        int[] chars = getNext("ABCDABD".toCharArray());
/*        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(getNextArray("ABCDABD".toCharArray())));*/
        System.out.println(kmpMatch("abcabaabaabcacb", "abaabcac"));
    }

    /**
     * 自己理解写的！
     * 得到next数组
     *
     * 后缀下标是相对的 相对于当前这个元素
     * 前缀下标是固定的 前缀下标的下一位就是可以再次与当前不匹配位置对齐的
     *
     * @param t 模式串转成的字符数组
     * @return next数组
     * 其中：next[0] = -1：当模式串的0号位置（模式串数组中的第一个字符）与目标串x位置不匹配的时候，让模式串-1号位置与目标串x位置尝试匹配，换句话说
     * 让模式串0号位置与目标串的x+1号位置进行匹配
     * next[1] = 0：当模式串1号位置与目标串x位置不匹配的时候，此时让模式串0号与目标串x位置匹配
     */
    private static int[] getNext(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        // 前缀j 从-1下标开始
        int j = -1;
        // 后缀i从下标0开始
        int i = 0;
        while (i < t.length - 1) {
            if (j == -1 || t[i] == t[j]) {// 如果后缀跟前缀相等 肯定要把后缀和前缀的指针同时后移
                // 当前缀下标为0时候 j和i也要++
                // 因为前缀为0时候意味着没有公共前后缀 此时next[i]就等于0  表示从模式串的0号位接着开始匹配
                i ++;
                j ++;
                next[i] = j;// 此处移动之后 可以填写next数组的值 // 假设匹配失败 下次开始的值肯定是前缀下标后移一位 对应j++
            }else {// 要是前缀和后缀对应的值不等 前缀就要前移
                j = next[j];// TODO ?
            }
        }
        return next;
    }

    /**
     * 博客上抄的
     * 得到next数组
     * next[0] = -1表示若模式串的第一位与目标串x位置不匹配时，则模式串的-1号位置与目标串x位置进行匹配，也就是说模式串0号位置（第一个字符）与目标串x+1位置进行匹配
     * next[1] = 0：当模式串1号位置与目标串x位置不匹配，则模式串0号位置与目标串x位置进行匹配
     * @param t
     * @return
     */
    public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k = next[j - 1];
            while (k != -1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }

    /**
     * kmp算法
     * @param s
     * @param t
     * @return 匹配到的字符串中第一个字符的下标
     */
    public static int kmpMatch(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
//        int[] next = getNextArray(t_arr);
        int[] next = getNext(t_arr);
        // i表示目标串的指针 j表示模式串的指针
        int i = 0, j = 0;
        // while出去条件是 两个数组任意一个遍历完
        while (i < s_arr.length && j < t_arr.length) {
            // j==-1 表示模式串0号位置与目标串x的下一位置进行比较  体现在i++ j++
            if (j == -1 || s_arr[i] == t_arr[j]) {
                i++;
                j++;
            } else
                j = next[j];// 当出现不匹配时候就根据next数组来决定模式串的指针指向
        }
        if (j == t_arr.length)// 如果j能遍历到最后 说明找到了  索引就是i-j  i是目标串最后的索引  减去模式串的长度就是匹配的起始位置
            return i - j;
        else
            return -1;

    }

}
