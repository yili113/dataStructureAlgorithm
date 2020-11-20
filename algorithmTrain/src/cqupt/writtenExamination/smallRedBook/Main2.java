package cqupt.writtenExamination.smallRedBook;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-30 19:24
 */
public class Main2 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int maxBoxes(int[][] boxes) {
        int len = boxes.length;
        if (len == 0)
            return 0;
        Arrays.sort(boxes, (o1, o2) -> {
            if (o1[0] != o2[0])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });
        int res = 1;
        for (int i = 0; i < len - 1; i++) {
            if (boxes[i][0] < boxes[i + 1][0] && boxes[i][1] < boxes[i + 1][1])
                res ++;
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _boxes_rows = 0;
        int _boxes_cols = 0;
        _boxes_rows = Integer.parseInt(in.nextLine().trim());
        _boxes_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _boxes = new int[_boxes_rows][_boxes_cols];
        for(int _boxes_i=0; _boxes_i<_boxes_rows; _boxes_i++) {
            for(int _boxes_j=0; _boxes_j<_boxes_cols; _boxes_j++) {
                _boxes[_boxes_i][_boxes_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = maxBoxes(_boxes);
        System.out.println(String.valueOf(res));

    }
}
