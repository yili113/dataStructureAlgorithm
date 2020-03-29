package cqupt.leetCode.tree.tireTree;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Liyi
 * @create 2020-03-28 9:40
 * 字典树--->解决字符前后缀问题
 * 前缀问题用将字符串正着插入到字典树中,后缀问题就需要将字符串反着插入到字典树当中
 */
public class T820 {
    public static int minimumLengthEncoding(String[] words) {
        int len = 0;
        TireTree tireTree = new TireTree();
        // 此处必须将单词按照长度进行排序,必须要先放入长度大的,不然短的放进去了,放长的时候还是会判定成新单词
        Set<String> sortedWords = sort(words);
        for(String word : sortedWords) {
            len += tireTree.insert(word);
        }
        return len;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(strs));
    }
    public static Set<String> sort(String[] words) {
        Set<String> set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {// 这种形式是按照长度从大到小排序
              if (o1.length() < o2.length())
                  return 1;
              else if (o1.length() > o2.length())
                  return -1;
              else
                  return o1.compareTo(o2);
            }
        });
        for(String word : words) {
            set.add(word);
        }
        return set;
    }
}
class TireTree {
    Tirenode root;// 定义根结点

    public TireTree() {
        root = new Tirenode();// 给根结点root初始化
    }

    /**
     * 将单词插入到字典树
     * @param word
     * @return 如果当前单词是新单词就返回单词长度+1(本题需要哪个#号);如果当前单词已是字典树中的后缀就返回0
     */
    public int insert(String word) {
        boolean isNew = false;
        Tirenode cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                isNew = true;
                cur.children[index] = new Tirenode();// 此题不需把单词的字母放进树种,只需要计算长度即可
            }
            cur = cur.children[index];
        }
        return  isNew ? word.length() + 1 : 0;
    }
}
// 字典树结点类
class Tirenode {
    Tirenode[] children;
    char val;

    public Tirenode() {
        children = new Tirenode[26];
    }

    public Tirenode(char val) {
        children = new Tirenode[26];
        this.val = val;
    }
}
