package cqupt.writtenExamination.tencent;

import java.util.*;

/**
 * @author yiLi
 * @create 2020-09-06 21:44
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            count.put(str, count.getOrDefault(str, 0) + 1);
        }
        LinkedList<Map.Entry<String, Integer>> descMap = helper(count);
        int temp = K;
        for (Map.Entry<String, Integer> entry1 : descMap) {
            temp --;
            System.out.println(entry1.getKey() + " " + entry1.getValue());
            if (temp == 0)
                break;
        }
        LinkedList<Map.Entry<String, Integer>> ascMap = helper2(count);
        int temp1 = K;
        for (Map.Entry<String, Integer> entry2 : ascMap) {
            temp1 --;
            System.out.println(entry2.getKey() + " " + entry2.getValue());
            if (temp1 == 0)
                break;
        }
    }

    private static LinkedList<Map.Entry<String, Integer>> helper(HashMap<String, Integer> map1) {
        LinkedList<Map.Entry<String, Integer>> list1 = new LinkedList<>(map1.entrySet());
        Collections.sort(list1, (o1, o2) -> {
            if (o2.getValue().compareTo(o1.getValue()) != 0)
                return o2.getValue().compareTo(o1.getValue());
            else
                return o1.getKey().compareTo(o2.getKey());
        });
        return list1;
    }
    private static LinkedList<Map.Entry<String, Integer>> helper2(HashMap<String, Integer> map2) {
        LinkedList<Map.Entry<String, Integer>> list2 = new LinkedList<>(map2.entrySet());
        Collections.sort(list2, (o1, o2) -> {
            if (o2.getValue().compareTo(o1.getValue()) != 0)
                return o1.getValue().compareTo(o2.getValue());
            else
                return o1.getKey().compareTo(o2.getKey());
        });
        return list2;
    }
}
