package cqupt.dataStructure.linkedList;

/**
 * @author yiLi
 * @create 2019-12-23 20:14
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义");
        HeroNode heroNode3 = new HeroNode(3, "吴用");
        HeroNode heroNode33 = new HeroNode(3, "小吴!!!");
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        int length = singleLinkedList.getLength(singleLinkedList.getHead());// 把头节点传入getLength方法中
        HeroNode lastIndexHeroNode = singleLinkedList.findLastIndexHeroNode(singleLinkedList.getHead(), 2);
        singleLinkedList.showList();
        singleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.showList();

    }
}

/**
 * 单链表
 */
class SingleLinkedList {
    // 头节点 不能动，没了就相当于没了整个链表 链表只能从头节点开始找
    HeroNode head = new HeroNode(0, "");// 头节点不存放数据 只是作为索引开始


    public HeroNode getHead() {
        return head;
    }

    /**
     * 顺序添加节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;// 头节点不能动
        while (true) {
            if(temp.next == null)// 空链表
                break;
            temp = temp.next;
        }
        // 上述循环之后 temp就为最后一个节点了
        temp.next = heroNode;
    }

    /**
     * 根据编号顺序进行添加
     * 1.要找到合适的位置进行添加
     * 2.newNode.next = temp.next temp节点原来的下一节点连接到新节点上
     * 3.temp.next = newNode temp节点现在的下一节点连接到新节点上
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;// 标志原本链表是否有新加入节点的编号的节点
        while (true) {
            if (temp.next == null)// 说明temp已经在链表最后
                break;
            if (temp.next.no > heroNode.no)// 说明temp下一节点的编号比新节点编号大 位置找到
                break;
            if (temp.next.no == heroNode.no) {// 表明新加入节点的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;// 向后移位
        }
        // 出了while循环就表明这个合适的位置找到了
        if (flag) {// 该编号节点已经存在
            System.out.println("此编号节点已经存在");
            return;
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 根据编号更改内容
     * @param heroNode
     */
    public void update(HeroNode heroNode) {
        if (head.next == null)// 空表，没法更新
            return;
        // 如果不是空表
        HeroNode temp = head;
        boolean flag = false;// 标记是否找到该编号的节点
        while (true) {
            if (temp.next == null)// 链表遍历完了
                break;
            if (temp.no == heroNode.no) {// 找到该编号的节点
                flag = true;
                break;
            }
            temp = temp.next;// 后移temp
        }
        // 出循环时候要么已经遍历完链表没找到该编号元素要么找到了该编号元素,temp即为该节点
        if (flag) {
            temp.name = heroNode.name;
        }else {
            System.out.printf("没有找到 %d 的节点\n", heroNode.no);
        }
    }
    /**
     * 显示
     */
    public void showList() {
        HeroNode temp = head.next;
        int count = 0;
        while (true) {
            if(temp == null)// 空链表  循环出口
                break;
            System.out.println(temp);
            count ++;
            temp = temp.next;
        }
        System.out.printf("链表有效个数是%d", count);
    }

    /**
     * 删除
     * @param num 要删除节点的编号
     */
    public void delete(int num) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {// 已经到链表结尾了
                break;
            }
            if (temp.next.no == num) {// 找到要删除的那个节点
                flag = true;
                // temp.next = temp.next.next;
                break;
            }
            // temp后移
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d节点不存在\n", num);
        }
    }

    /**
     * 返回链表有效节点个数
     * @param head 链表的头节点
     * @return
     */
    public static int getLength(HeroNode head) {
        if (head.next == null)
            return 0;
        int count = 0;
        HeroNode temp = head.next;
/*        while (true) {
            if (temp == null) {
                break;
            }
            count ++;
            temp = temp.next;
        }*/
        while (temp != null) {// 不加if写法
            count ++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 查找倒数第k个节点
     * 1.先得到链表的有效个数
     * 2.从第一个非头节点开始移动length-index-1次
     * @param head 链表的头节点
     * @param index 倒数第index个
     * @return
     */
    public static HeroNode findLastIndexHeroNode(HeroNode head, int index) {
        if (head.next == null)
            return null;// 空链表
        int length = getLength(head);
        // 判断index是否越界
        if (index <=0 || index > length)
            return null;
        HeroNode temp = head.next;
        for (int i = 0; i < length - index; i++) {// 移动了length-index-1次  从第一个非头节点开始移动
             temp = temp.next;
        }
        return temp;
    }

    /**
     * 单链表翻转
     * @param head 链表的头节点
     */
    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null)
            return;// 只有一个节点或者只有头节点
        HeroNode cur = head.next;// 当前节点
        HeroNode next = null;// 当前节点的下一节点  当前节点去做翻转的时候，如果此时没有下一节点的引用那么，链表就断了
        HeroNode reverseNode = new HeroNode(0, "");
        while (cur != null) {
            next = cur.next;// 当前节点的下一节点
            cur.next = reverseNode.next;// reverseNode原本的下一节点接到cur后面
            reverseNode.next = cur;// cur接到reverseNode后面
            // 以上两步完成cur插入到reverseNode和reverseNode之间
            cur = next;// 后移
        }
        // while之后是形成了翻转的链表
        // 现在只需把翻转的链表接回到原先的head后面  这样就可以继续根据head找到链表
        head.next = reverseNode.next;
    }

}
/**
 * 英雄节点类
 */
class HeroNode {
    public int no;
    public String name;
    public HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}