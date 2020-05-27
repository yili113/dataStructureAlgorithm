package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-26 16:36
 * 链表结点怪异的删除方式
 *
 * 结论：不知道头结点的话要删除一个结点
 * 1.是没法删除链表的最后一个结点
 * 2.并不是真正意义上删除掉某个结点,只是简单对结点的值进行了替换
 */
public class Demo16 {
    // 以下这种方式没法删除最后一个元素
    // 不给出头节点
    // 删除指定结点
    public void removeNode1(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        while (cur.next != null) {
            cur.val = cur.next.val;
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;// 把最后那个多余的结点置空
    }


    // 这种也没法删除最后一个结点
    public void removeNode(ListNode node) {
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
