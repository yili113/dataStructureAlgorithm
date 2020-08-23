package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-17 9:09
 * 合并链表--递归
 */
public class Main2 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);// 将list1.next和list2计算结果后返回的结点肯定是要接在list1后面的
            return list1;// 这种情况就要把list1最为头结点
        }else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
