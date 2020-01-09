package cqupt.dataStructure.recursion;

/**
 * @author yiLi
 * @create 2019-12-29 9:35
 */
public class Labyrinth {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        // 置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("####################");
        // 找路
        setWay(map, 1, 1);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 规定：0位没走过的地方，1为墙，2为走过并且为通路的地方，3为走过但是不通的地方
     * 当map[6][5]==2 表示地图能走通
     * 行走路线：下--右--上--左
     * @param map 原始地图
     * @param i 起始横坐标
     * @param j 起始纵坐标
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {// 通路了
            return true;
        }else {// 还没找到通路
            if (map[i][j] == 0){// 这个地方还没走过
                map[i][j] = 2;// 先假定这个地方可以通，然后看下一个点是否能通
                if (setWay(map, i + 1, j)) {// 向下走 如果能通则if内为真
                    return true;
                }else if (setWay(map, i , j + 1)){
                    return true;
                }else if (setWay(map, i - 1, j)){
                    return true;
                }else if (setWay(map, i, j - 1)){
                    return true;
                }else {// 表示这个点的上下左右都不通 则这个点置为3
                    map[i][j] = 3;
                    return false;
                }
            }else {// 这个点如果不是0的话 那么这个点可能就是1,2,3
                return false;
            }
        }
    }
}
