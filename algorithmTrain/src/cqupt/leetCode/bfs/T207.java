package cqupt.leetCode.bfs;

import java.util.*;

/**
 * @author Liyi
 * @create 2020-03-18 19:34
 * 课程表---拓扑排序---bfs
 */
public class T207 {


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;
        if (prerequisites.length == 0)
            return true;
        int[] res = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();// value需要key才行
        int[] degree = new int[numCourses];// 定义每个课程的入度 假如说入度为1就表明当前课程需要1门课程作为前提
        for (int[] ints : prerequisites) {// 对于prerequisites [0]需要[1] 也就是说[1]对应key,[0]对应value
            if (!map.containsKey(ints[1])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(ints[0]);
                map.put(ints[1], list);
                degree[ints[0]] ++;
            }else {
                List<Integer> curList = map.get(ints[1]);
                curList.add(ints[0]);// 可以这么对已有的key添加新的value
                degree[ints[0]] ++;
            }
        }
        // 至此每个课程都有了自己的入度
        // 1.把入度为0的首先加入到队列中
        int count = 0;// 记录可以修的课程数
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0)
                queue.addLast(i);
        }
        // 2.依次判断队列中的课程(队列中的课程都是可以上的，此时需要判断有哪些课程需要队列中的课程)
        while (!queue.isEmpty()) {
            Integer cur_courses = queue.removeFirst();
            count ++;
            if (count == numCourses)
                return true;
            if (map.containsKey(cur_courses)) {// 之前一直判断条件写的是：这个key对应的value是否为空 一直空指针。其实都没有这个key
                for (Integer next_courses : map.get(cur_courses)) {
                    degree[next_courses] --;
                    if (degree[next_courses] == 0) {// 此时这门课程的入度也为0了，不要别的课程了，就可以加入到队列中
                        queue.addLast(next_courses);
                    }
                }
            }else {

            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(3, prerequisites));
    }
}
