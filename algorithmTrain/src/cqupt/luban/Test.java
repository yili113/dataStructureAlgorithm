package cqupt.luban;

import java.util.ArrayList;

/**
 * @author Liyi
 * @create 2020-03-06 10:46
 */
public class Test {


    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        char c = Character.highSurrogate(list.remove(2));
        char c1 = Character.forDigit(list.remove(0), 10);
        System.out.println(c);
        System.out.println(c1);

    }
    static class Person {
        public String id;
        public Person(String id) {
            this.id = id;
        }
        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Person person = (Person) o;
//            return Objects.equals(id, person.id);
            Person person = (Person) o;
            return this.id == person.id;
        }

    }
}
