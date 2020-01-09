package cqupt.dataStructure.queue;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2019-12-23 19:28
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
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
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }
}

/**
 * 数组模拟环形队列
 * front:第一个元素的索引
 * rear:最后一个元素的下一个位置 约定预留一个位置
 * 队列满：(rear+1)%maxSize==front
 * 队列空：rear==front
 * 队列中有效元素个数 (rear+maxsize-front)%maxSize
 */

class CircleArrayQueue {
    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;// 初始值为0
        rear = 0;// 初始值为0
    }

    public boolean isFull() {
        return (rear+1)%maxSize==front;
    }
    public boolean isEmpty() {
        return rear==front;
    }
    public void add(int data) {
        if (isFull())
            throw new RuntimeException("is full");
        arr[rear] = data;
        // rear 后移，但是要考虑循环的情况 取模 不能是rear++
        rear = (rear + 1) % maxSize;
    }
    public int get() {
        if (isEmpty())
            throw new RuntimeException("is empty");
        int temp = arr[front];// 取出数据 不能直接返回 不然就没法front移位操作了
        front = (front + 1) % maxSize;
        return temp;
    }
    public int size() {
        return (rear+maxSize-front)%maxSize;
    }
    public void showAll() {
        if (isEmpty())
            throw new RuntimeException("is empty");
        for (int i = front; i < size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }

}
