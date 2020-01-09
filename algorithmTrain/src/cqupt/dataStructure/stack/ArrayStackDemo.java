package cqupt.dataStructure.stack;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2019-12-26 21:55
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            key = scanner.next().charAt(0);// 接收第一个字符
            switch (key) {
                case 's':// 显示队列数据
                    arrayStack.showStack();
                    break;
                case 'a':// 添加数据
                    System.out.println("please input:");
                    int input = scanner.nextInt();
                    arrayStack.push(input);
                    break;
                case 'g':// 取出数据
                    int data = arrayStack.pop();
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
 * 用数组模拟栈
 */
class ArrayStack {
    private int maxSize;
    private int[] arr;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 栈满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 查看
     * @return
     */
    public int peek() {
        return arr[top];
    }

    /**
     * 入栈
     * @param data
     */
    public void push(int data) {
        if (isFull())
            throw new RuntimeException("stack is full");
        top ++;
        arr[top] = data;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty())
            throw new RuntimeException("stack is empty");
        int value = arr[top];
        top --;
        return value;
    }

    /**
     * 打印
     */
    public void showStack() {
        if (isEmpty())
            throw new RuntimeException("stack is empty");
        for (int i = top; i > 0 ; i--) {
            System.out.printf("第%d个元素是%d\n", i, arr[i]);
        }
    }

    /**
     * 返回运算符的优先级
     * @param oper
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }else if (oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1;
        }
    }

    /**
     * 判断是否是运算符
     * @param ch
     * @return
     */
    public boolean isOper(char ch) {
        return ch=='+' || ch == '-' || ch =='*' || ch =='/';
    }

    /**
     * 两个数进行运算
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
                default:
                    break;
        }
        return res;
    }

}
