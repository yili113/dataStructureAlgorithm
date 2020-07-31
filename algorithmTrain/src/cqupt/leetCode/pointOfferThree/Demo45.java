package cqupt.leetCode.pointOfferThree;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author yiLi
 * @create 2020-07-29 20:33
 * 把数组排成最小的数
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class Demo45 {
    public String minNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num + "");
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return Integer.parseInt(o1+o2) - Integer.parseInt(o2+o1);
                return (o1+o2).compareTo(o2+o1);

            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : list)
            sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student1 s1 = new Student1("小张");
        Student1 s2 = new Student1("小李");
        Demo45.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
    }

    private static void swap(Student1 x, Student1 y) {
//        Student1 temp = x;
//        x = y;
//        y = temp;
//        System.out.println("x:" + x.getName());
//        System.out.println("y:" + y.getName());
        x.setName("大大");
        y.setName("哒哒哒哒");
    }
}
class Student1 {
    private String name;

    public Student1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
