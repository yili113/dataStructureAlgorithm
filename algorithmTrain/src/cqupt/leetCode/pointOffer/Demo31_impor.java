package cqupt.leetCode.pointOffer;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-01 11:02
 * 栈的压入弹出序列
 */
public class Demo31_impor {
    // pushed中的顺序 pop中出现两次跟push相同的顺序就为false
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 1)
            return true;
        int count = 0;
        for (int i = 0; i < pushed.length - 1; i++) {
//            int low = i - 1;
//            int fast = i;
            for (int k = i + 1; k < pushed.length; k++) {
                for (int j = 0; j < popped.length; j++) {
                    int j1 = 0;
                    int j2 = 0;
                    if (popped[j] == pushed[i])
                        j1 = j;
                    if (popped[j] == pushed[k])
                        j2 = j;
                    if (j1 < j2)
                        count ++;
                }

            }
        }
        System.out.println(count);
        return count < 2;
    }
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index ++;
            }
        }
        return stack.isEmpty();
    }
}
