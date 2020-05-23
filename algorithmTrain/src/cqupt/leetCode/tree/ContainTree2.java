package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-22 15:10
 */
public class ContainTree2 {
    public boolean isSubtree(TreeNode t1, TreeNode t2) {
        String s1 = serialTree(t1);
        String s2 = serialTree(t2);
        int index = getIndex(s1, s2);
        return index != -1;
    }
    public String serialTree(TreeNode root) {
        if (root == null)
            return "#!";
        String str = root.val + "!";
        str += serialTree(root.left);
        str += serialTree(root.right);
        return str;
    }
    public int[] getNext(char[] ch) {
        if (ch == null || ch.length == 0)
            return new int[]{-1};
        int[] next = new int[ch.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < ch.length) {
            if (ch[pos - 1] == ch[cn]) {
                next[pos ++] = ++cn;
            }else if (cn > 0)
                cn = next[cn];
            else
                next[pos ++] = 0;
        }
        return next;
    }
    public int getIndex(String s, String m) {
        if (s == null || m == null || s.length() == 0 || m.length() == 0)
            return -1;
        char[] ss = s.toCharArray();
        char[] mm = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNext(mm);
        while(si < s.length() && mi < m.length()) {
            if (ss[si] == mm[mi]) {
                si ++;
                mi ++;
            }else if (next[mi] == -1)
                si ++;
            else
                mi = next[mi];
        }
        return mi == mm.length ? si - mi : -1;
    }
}
