package cqupt.dataStructure.sparseArray;

/**
 * @author yiLi
 * @create 2019-12-22 10:02
 */
public class SparseArr {
    public static void main(String[] args) {
        // 定义原始数组
        int[][] chessArr1 = new int[5][5];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for(int[] row:chessArr1) {
            for (int item:row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum ++;
                }
            }
        }
        // 定义稀疏数组
        int[][] sprseArr = new int[sum + 1][3];// 固定的三列
        sprseArr[0][0] = chessArr1.length;
        sprseArr[0][1] = chessArr1[0].length;
        sprseArr[0][2] = sum;
        int count = 0;// 稀疏数组行的计数器
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count ++;
                    sprseArr[count][0] = i;
                    sprseArr[count][1] = j;
                    sprseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("################");
        // 打印稀疏数组
        for(int[] row:sprseArr) {
            for (int item:row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        // 将稀疏数组映射到原数组中
        int[][] chessArr2 = new int[sprseArr[0][0]][sprseArr[0][1]];
        for (int i = 1; i < sprseArr.length; i++) {
            chessArr2[sprseArr[i][0]][sprseArr[i][1]] = sprseArr[i][2];
        }
        System.out.println("################");
        // 打印原数组
        for(int[] row:chessArr2) {
            for (int item:row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}
