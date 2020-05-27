package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-26 15:19
 */
public class Demo15 {
    public void sort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = arr[start];
        int l = start + 1;
        int r = end;
        while (l <= r) {
            if (arr[l] < pivot) {
                l ++;
                continue;
            }
            if (arr[r] >= pivot) {
                r --;
                continue;
            }
            swap(arr, l, r);
        }
        swap(arr, start, r);
        sort(arr, start, r - 1);
        sort(arr, l, end);
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    public ListNode selectSortNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tail = null;// 排序好的链表尾部
        ListNode cur = head;// 未排序链表的头部
        ListNode small = head;
        ListNode smallPre = null;
        while (cur != null) {
            small = cur;
            smallPre = getSmallNodePre(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;// cur指向未排序链表的头部,如果cur==small说明cur指向的是最小的结点,此时cur肯定要后移
            if (tail == null) {// head始终指向排序好的链表的头部,tail==null说明排序好的链表还没有结点
                head = small;
            }else {
                tail.next = small;
            }
            tail = small;// tail永远指向最近选出来的未排序链表里面的最小结点
        }
        return head;
    }

    /**
     * 得到未排序链表中最小结点的前一结点
     * @param head
     * @return
     */
    private ListNode getSmallNodePre(ListNode head) {
        ListNode smallPre = null;
        ListNode small = head;
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val < small.val) {
                small = cur;
                smallPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
