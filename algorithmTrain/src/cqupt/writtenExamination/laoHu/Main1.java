package cqupt.writtenExamination.laoHu;

/**
 * @author yiLi
 * @create 2020-09-06 16:47
 */
public class Main1 {
    public int primePalindrome (int N) {
        // write code here

        int ans = N;
        while (!(isPrime(ans) &&isHuiWen(ans)))
            ans ++;
        return ans;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private boolean isHuiWen(int num) {
        String s = num + "";
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }

}
