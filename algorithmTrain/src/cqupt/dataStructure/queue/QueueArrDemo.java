package cqupt.dataStructure.queue;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2019-12-22 11:04
 */
public class QueueArrDemo {
    public static void main(String[] args) {
        QueueArr queue = new QueueArr(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            key = scanner.next().charAt(0);// 接收第一个字符
            switch (key) {
                case 's':// 显示队列数据
                    queue.showAll();
                    break;
                case 'a':// 添加数据
                    System.out.println("please input:");
                    int input = scanner.nextInt();
                    queue.add(input);
                    break;
                case 'g':// 取出数据
                    int data = queue.get();
                    System.out.println("output is:" + data);
                    break;
                case 'h':// 查看头元素
                    int peek = queue.peek();
                    System.out.println("head is:" + peek);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }

}
class QueueArr {
    // 属性
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    // 构造器
    public QueueArr(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;// 指向第一数据的前一个位置
        rear = -1;// 指向最后一个数据 初始化时二者相同
    }

    /**
     * 判断是否为满
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 入队
     * @param data
     */
    public void add(int data) {
        if(isFull())
            return;
        rear ++;
        arr[rear] = data;
    }

    /**
     * 出队
     */
    public int get() {
        if (isEmpty())
            throw new RuntimeException("queue is empty");
        front ++;
        return arr[front];
    }

    /**
     * 查看队列第一个元素
     * @return
     */
    public int peek() {
        if (isEmpty())
            throw new RuntimeException("queue is empty");
        return arr[front + 1];// 此处查看是在arr里面的front位置+1 不影响真实front位置
    }

    /**
     * 显示所有元素
     */
    public void showAll() {
        if (isEmpty())
            throw new RuntimeException("queue is empty");
/*        for (int item : arr) {
            System.out.print(item + " ");
        }*/
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}
