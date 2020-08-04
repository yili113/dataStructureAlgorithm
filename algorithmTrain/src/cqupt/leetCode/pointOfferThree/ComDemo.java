package cqupt.leetCode.pointOfferThree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author yiLi
 * @create 2020-08-03 15:26
 */
public class ComDemo {

    public static void main(String[] args) {
        Student s1 = new Student(3, "li");
        Student s2 = new Student(2, "aa");
        Student s3 = new Student(4, "bb");
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });// 可行 匿名内部类方式
        // 对一个类实现排序接口的话就可以将该类的对象放入到treeMap或者treeSet中
        // TreeSet底层使用红黑树
        System.out.println(Collections.binarySearch(list, s2));


//        TreeMap<Student, String> treeMap = new TreeMap<>();
//        treeMap.put(s1, "li");
//        treeMap.put(s2, "aa");
//        treeMap.put(s3, "bb");
//        System.out.println(treeMap);
    }

}
class Student implements Comparable<Student> {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

}
