package cqupt.leetCode.linkedList;

/**
 * @author yiLi
 * @create 2020-05-20 10:45
 */
public class T725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null)
            return new ListNode[]{null};
        ListNode[] listNodes = new ListNode[k];
        int count = 0;
        ListNode cur = root;
        while (cur.next != null) {
            count ++;
            cur = cur.next;
        }
        System.out.println(count + 1);
        int group = (count + 1) / k;// 计算每组最少放多少个
        int mod = (count + 1) - (group * k);// 计算余数
        cur = root;// 此处必须重新cur=root  前面计算长度已经将cur的引用改了
        for (int i = 0; cur != null && i < k; i++) {// 放k组
            listNodes[i] = cur;// 先把第i组的头结点放进去
            // 判断这组需要放多少元素,根据余数判断
            int kSzie = group + (mod > 0 ? 1 : 0);// mod还有剩余就多放一个
            // 要注意三目运算符与其他运算符的优先级
            // 写三目运算符的时候要加()
            mod --;
            for (int j = 0; j < kSzie - 1; j++) {// 此处kSzie - 1是因为前面已经把头部计算了
                cur = cur.next;
            }
            // 保存上一个链表的尾部
            ListNode next = cur.next;
            // 让上一个链表尾部置空
            cur.next = null;
            // 上一个链表的尾部的next为下一个链表的头
            cur = next;
        }
        return listNodes;
    }

    public static void main(String[] args) {
        System.out.println(1 + 2 > 0 ? 1 : 0);
    }
}
