package cqupt.leetCode.tree.tireTree;

/**
 * @author Liyi
 * @create 2020-03-28 10:16
 * 实现字典树
 */
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;// root结点是为空的
        for (int i = 0; i < word.length(); i++) {
            if (!cur.containsKey(word.charAt(i)))
                cur.put(word.charAt(i), new TrieNode());
            cur = cur.get(word.charAt(i));// 移动cur指针,指向新的结点
        }
        cur.setEnd();// 表示cur已经到了单词结尾
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.containsKey(word.charAt(i))) {
                cur = cur.get(word.charAt(i));
            }else
                return null;
        }
        return cur;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
class TrieNode {

    // R links to node children
    private TrieNode[] children;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        children = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return children[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return children[ch -'a'];
    }
    // 在当前结点的孩子结点中找合适的位置put
    public void put(char ch, TrieNode node) {
        children[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

