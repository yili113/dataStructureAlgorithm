package cqupt.leetCode.pointOfferThree.hashMapTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author yiLi
 * @create 2020-07-23 9:14
 *
 * 性能对比：除了并行流之外,剩下的差不多,foreach底层也是迭代器实现的,反编译之后就能看到
 * 安全对比：foreach中删除元素是不安全的,并发修改异常,主要是modCount与expectedModCount不一致导致
 *          迭代器中删除元素是安全的,用lambda表达式中的
 *          在遍历修改元素时候,modCount被改变导致！=expectedModCount,导致并发修改异常
 *          但是用迭代器的话会同步修改expectedModCount,不会抛异常
 * 快速失败机制：就是上述通过modCount和expectedModCount实现的
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");


        // 迭代器遍历
        // 1.
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 2.
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext())
            System.out.println(iterator1.next());
        // foreach
        // 3.
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry);
        }
        // 4.
        for (Integer key : map.keySet())
            System.out.println(key);
        // 5.lambda
        map.forEach((key, value) -> {
            System.out.println(key);
        });
        // 6.stream
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey());
        });
        // 7.并行流
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey());
        });

        // 迭代器根据key删除元素的正确方式
        // 利用removeIf
        map.keySet().removeIf(key -> key == 1);
        map.keySet().forEach(key -> {
            System.out.println(key);
        });

        // 通过stream删除map中key对应的元素
        // 利用filter
        map.keySet().stream().filter(m -> 1 != m).forEach(key -> {
            System.out.println(key);
        });
    }
}
