package cqupt.dataStructure.stack;

/**
 * @author yiLi
 * @create 2019-12-27 9:33
 */
public class Cal {
    public static void main(String[] args) {
        String exp = "70*2*2-5+1-5+3-4";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int index = 0;// 扫描栈中元素
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int oper = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            ch = exp.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {// 如果是运算符
                // 判断符号栈是否为空
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                }else {// 符号栈不为空
                    // 比较运算符优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        // 栈中符号优先级大于等于要入栈的符号
                        // 此时弹出数字栈的两个元素和符号栈的一个元素
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        // 将计算结果入数字栈 并将刚才要入符号栈的符号再入符号栈
                        numStack.push(res);
                        operStack.push(ch);
                    }else {// 符号优先级不满足就直接入符号栈
                        operStack.push(ch);
                    }
                }
            }else {// 如果是数
                // 直接入数字栈 但是现在ch是字符 得转成数字
                // numStack.push(ch - 48); // 单位数
                // 考虑多位数
                // 是数的话先拼接
                keepNum += ch;
                if (index == exp.length() - 1) {// 当前数字是最后一个数
                    numStack.push(Integer.parseInt(keepNum));
                }else {// 当前数字不是最后一个数
                    // 看下一个ch是数字还是符号
                    if (operStack.isOper(exp.substring(index + 1, index + 2).charAt(0))) {// 下一个是符号
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";// 当下一个是符号的时候才清空
                    }
                }
            }
            // 判断while出口条件 当扫描到末尾时候
            index ++;// 后移扫描索引
            if (index >= exp.length()) {
                break;
            }
        }
        // while出来之后 要把剩下的数计算完
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = numStack.cal(num1, num2, oper);
                // 将计算结果入数字栈
                numStack.push(res);
            }
        }
        // 此while之后数字栈只剩一个数字 符号栈为空
        System.out.printf("表达式%s = %d", exp, numStack.pop());
    }
}
