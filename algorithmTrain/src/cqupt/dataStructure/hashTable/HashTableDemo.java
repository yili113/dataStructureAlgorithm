package cqupt.dataStructure.hashTable;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-01-06 10:14
 * 哈希表
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner  scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add 添加雇员");
            System.out.println("list 显示雇员");
            System.out.println("find 查找雇员");
            System.out.println("delete 删除雇员");
            System.out.println("exit 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入雇员id");
                    int id = scanner.nextInt();
                    System.out.println("请输入雇员姓名");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入需要找的雇员id");
                    id = scanner.nextInt();
                    hashTable.findById(id);
                    System.out.println();
                    break;
                case "delete":
                    System.out.println("请输入需要删除的雇员id");
                    id = scanner.nextInt();
                    hashTable.deleteById(id);
                    System.out.println();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    default:
                        break;
            }
        }

    }
}

/**
 * hashTable
 * 初始化hash表的时候 一定不能忘记初始化每条链表
 */
class HashTable {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        // 这时候一定不要忘记初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     * @param emp
     */
    public void add(Emp emp) {
        int linkedListNo = hashFun(emp.id);
        // 添加到相应的链表中
        empLinkedLists[linkedListNo].add(emp);
    }

    /**
     * 显示雇员信息
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);

        }
    }

    /**
     *
     * @param id
     * @return
     */
    public void findById(int id) {
        // 先看需要找得id在那一条链表中
        int linkedListNo = hashFun(id);
        Emp empById = empLinkedLists[linkedListNo].findEmpById(id);
        if (empById == null) {
            System.out.printf("编号%d的雇员没有找到", id);
        }else {
            System.out.printf("找到第%d条链表中的编号为%d姓名为%s的雇员", linkedListNo, id, empById.name);
        }
    }
    /**
     * 取模的hash函数
     * @param no
     * @return
     */
    public int hashFun(int no) {
        return no%size;
    }

    /**
     * 根据id的来删除
     * @param id
     */
    public void deleteById(int id) {
        // 先找到该雇员在哪个链表中
        int linkedListNo = hashFun(id);
        // 再删除
        empLinkedLists[linkedListNo].deleteEmpById(id);
    }
}

/**
 * 雇员信息类
 */
class Emp {
    public int id;
    public String name;
    public Emp next;// 指向下一个emp 默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

/**
 * 雇员链表类
 */
class EmpLinkedList {
    private Emp head;// 头节点 这次不为空 第一个雇员信息直接放在head里面

    /**
     * 添加雇员  默认自增ID 在链表最后面插入
     * @param emp
     */
    public void add(Emp emp) {
        // 如果是第一个雇员
        if (head == null) {// 表示链表为空
            head = emp;
            return;
        }
        // 如果不是第一个雇员 则遍历到最后一个雇员那
        // 需要一个辅助节点
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {// 已经遍历到最后了
                break;
            }
            curEmp = curEmp.next;
        }
        // 当退出了上述的while之后就表示已经到最后了
        curEmp.next = emp;
    }

    /**
     * 显示列表
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("第"+no+"条列表为空");
            return;
        }
        Emp curEmp = head;
        System.out.print("第"+no+"条链表的信息为");
        while (true){
            System.out.printf("-->id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    /**
     * 根据id查找雇员
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {// 找到了 此时curEmp就是需要的
                break;
            }
            // 退出条件
            if (curEmp.next == null) {// 找到最后也没找到需要得
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        // while循环之后 不管找没找到curEmp都是需要的
        return curEmp;
    }

    /**
     * 根据雇员id进行删除雇员
     * 次删除方法不能删除第一个雇员，因为第一个雇员是头节点，以前头节点是不存放信息的
     * 所以不能删除第一个雇员，要是想删除第一个雇员的话，得另外弄个空的头节点
     * @param id
     * @return
     */
    public void deleteEmpById(int id) {
        if (head == null) {// 空链表
            System.out.println("链表为空");
            return;
        }
        Emp curEmp = head;// curEmp的下一个节点是要删除的那个节点
        boolean flag = false;// 判断是否找到需要的雇员
        while (true) {
            if (curEmp.next == null) {
                // 到链表结尾了
                break;
            }
            if (curEmp.next.id == id) {// 找到要删除的那个节点
                flag = true;
                break;
            }
            // temp后移
            curEmp = curEmp.next;
        }
        if (flag) {
            curEmp.next = curEmp.next.next;
            System.out.printf("已经删除了%d id的雇员\n", id);
        }else {
            System.out.printf("要删除的%d节点不存在\n", id);
        }
    }
}
