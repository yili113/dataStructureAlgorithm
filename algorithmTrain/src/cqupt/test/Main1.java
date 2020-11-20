package cqupt.test;

/**
 * @author yiLi
 * @create 2020-11-15 10:06
 */
public class Main1 {
    public static void main(String[] args) {

    }

    private static double help(int total, String str) {
        char[] ch = str.toCharArray();
        int len = ch.length;
        double curSpeed = 1;
        double totalTime = 0;
        int addTime = 0;
        double curTime = 0;
        for (int i = 0; i < len; i++) {
            if (ch[i] == '.') {
                curSpeed = 1;
                if (addTime > 0) {
                    curSpeed *= 2;
                    curTime = 1 / curSpeed;
                    totalTime += curTime;
                    addTime -= curTime;
                }else {
                    curTime = 1 / curSpeed;
                    totalTime += curTime;
                }
            }else if (ch[i] == 'w') {
                curSpeed = 0.5;
                if (addTime > 0) {
                    curSpeed *= 2;
                    curTime = 1 / curSpeed;
                    addTime -= curTime;
                    totalTime += curTime;
                }else {
                    curTime = 1 / curSpeed;
                    totalTime += curTime;
                }
            }else if(ch[i] == '>') {
                addTime = 5;// 只要碰到'>'就直接更新加速时间为5
                curSpeed = 2;
                curTime = 1 / curSpeed;
                totalTime += curTime;
                addTime -= curTime;
            }else if (ch[i] == 's') {
                curSpeed = 1;
                addTime --;
                totalTime ++;
                if (addTime > 0) {
                    curSpeed *= 2;
                    curTime = 1 / curSpeed;
                    totalTime += curTime;
                    addTime -= curTime;
                }else {
                    curTime = 1 / curSpeed;
                    totalTime += curTime;
                }
            }else if (ch[i] == 'm') {
                curSpeed = 1;
                addTime -= 2;
                totalTime += 2;
                if (addTime > 0) {
                    curSpeed *= 2;
                    curTime = 1 / curSpeed;
                    totalTime += curTime;
                    addTime -= curTime;
                }else {
                    curTime = 1 / curSpeed;
                    totalTime += curTime;
                }
            }
        }
        return totalTime;
    }
}
