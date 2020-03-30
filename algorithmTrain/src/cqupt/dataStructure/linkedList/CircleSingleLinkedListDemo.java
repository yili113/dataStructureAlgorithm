package cqupt.dataStructure.linkedList;

/**
 * @author yiLi
 * @create 2019-12-26 20:17
 * 约瑟夫问题
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.showBoy();
        // 调用这个方法时候一定要注意 参数nums是要提前传进去的 不然没有那么多节点
        circleSingleLinkedList.jesopfu(1,3,5);
    }
}

/**
 * 环形链表
 */
class CircleSingleLinkedList {
    private Boy first = null;// 第一个节点

    /**
     * 构成环形链表的孩子数
     * @param nums
     */
    public void add(int nums) {
        // 校验参数
        if (nums < 1)
            return;
        Boy curBoy = null;// 辅助变量 因为first不能动
        for (int i = 1; i <= nums ; i++) {// for把孩子都加进去
            Boy boy = new Boy(i);// 创建每个孩子
            // 构建第一个环
            if (i == 1) {
               first = boy;
               first.setNext(first);
               curBoy = first;
            }else {
                // 后续的孩子加进来 每进来一个都会构成环
                curBoy.setNext(boy);// boy为当前正在加入的孩子
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     *
     * @param k 从第k个小孩开始数
     * @param m 每次数m次
     * @param nums 原始小孩个数
     */
    public void jesopfu(int k, int m, int nums) {
        // 参数校验
        if (k < 1 || k > nums || first == null)
            return;
        Boy helper = first;// 辅助指针
        // 先将helper指到最后一个节点  为的是与first一起始终构成环
        while (helper.getNext() != first)
            helper = helper.getNext();
/*        while (true) {
            if (helper.getNext() == first)
                break;
            helper = helper.getNext();// 后移
        }*/
        // 从第k个小孩开始数 那就相当于先移动了k-1次
        for (int i = 0; i < k-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            // 循环出口是只有一个节点时候
            if (first == helper)
                break;
            // 否则first和helper移动m次
            for (int i = 0; i < m; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 移动m次之后 要出圈的就是first的位置
            System.out.printf("出圈的小孩编号是%d\n", first.getNo());
            // 有小孩出圈之后要进行将链表恢复成环形
            first = first.getNext();
            // System.out.printf("出圈后first此时编号是%d\n", first.getNo());
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的一个小孩编号是%d\n", first.getNo());
    }

    /**
     * 依次打印
     */
    public void showBoy() {
        Boy curBoy = first;
        while(true) {
            if (first == null)// 环形链表内无孩子
                break;
            // curBoy = first;// 这条一定要写在while外面 不然每次while都是curBoy==first
            System.out.printf("当前是%d号孩子\n", curBoy.getNo());
/*            curBoy = curBoy.getNext();
            if (curBoy.getNext() == first)
                break;*/
            // 上面两条不能写反了 不然会少打印的
            if (curBoy.getNext() == first)
                break;
            curBoy = curBoy.getNext();
        }
    }
}
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
