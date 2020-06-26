package cqupt.bookTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * @author yiLi
 * @create 2020-06-25 13:05
 */
public class PrimeUtil {
    public static boolean isPrime(int num) {
        int temp = num;
        if (temp < 2)
            return false;
        for (int i = 2; i < Math.sqrt(temp); i++) {
            if (temp % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.println(dateStr1);
        IntStream.range(1, 1000000).filter(PrimeUtil::isPrime).count();
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println(dateStr2);
        IntStream.range(1, 1000000).parallel().filter(PrimeUtil::isPrime).count();
//        System.out.println(count);
        Date date3 = new Date();
        String dateStr3 = simpleDateFormat.format(date3);
        System.out.println(dateStr3);

    }
}
