package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-22 14:40
 */
public class Kmp {


    public int[] getNext(char[] ch) {
        if (ch == null || ch.length == 0)
            return new int[]{-1};
        int[] next = new int[ch.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < ch.length) {
            if (ch[pos - 1] == ch[cn])
                next[pos ++] = ++cn;
            else if (cn > 0)
                cn = next[cn];
            else
                next[pos ++] = 0;
        }
        return next;
    }

    public int getIndex(String s, String m) {
        if (s == null || m == null || s.length() == 0 || m.length() == 0)
            return -1;
        char[] sm = s.toCharArray();
        char[] mm = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNext(mm);
        while (si < s.length() && mi < m.length()) {
            if (sm[si] == mm[mi]) {
                si ++;
                mi ++;
            }else if (next[mi] == -1)// next[mi]==-1就表示 要用si的下一个位置跟当前的mi位置比较
                // 所以 si++  mi不动
                si ++;
            else
                mi = next[mi];// 这种情况就是mi和si对应位置不同,但是mi根据next数组往前跳
        }
        return mi == m.length() - 1 ? si - mi : -1;
    }
}
