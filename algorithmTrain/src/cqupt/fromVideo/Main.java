package cqupt.fromVideo;

import java.util.ArrayList;

/**
 * @author yiLi
 * @create 2019-10-08 14:42
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> I = new ArrayList<>();
        for (int i = 0; i< 10; i ++) {
            I.add(String.valueOf(i));
        }
        /*I.stream().filter(e -> ! e.equals("5")).forEach(System.out::print);*/
        for (String string : I){
            I.remove(string);
        }
        System.out.println(I.size());
    }
}
