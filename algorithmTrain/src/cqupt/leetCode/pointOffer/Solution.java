package cqupt.leetCode.pointOffer;

import java.util.*;

/**
 * @author yiLi
 * @create 2020-06-01 9:00
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;
        if (prerequisites.length == 0)
            return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] dgrees = new int[numCourses];// 每个课程依赖的课程数
        for(int[] next : prerequisites) {
            if (!map.containsKey(next[1])) {// 看有多少课程依赖next[1]
                ArrayList<Integer> list = new ArrayList<>();
                list.add(next[0]);
                map.put(next[1], list);// next[0]依赖next[1]
                dgrees[next[0]] ++;
            }else {
                List<Integer> cur = map.get(next[1]);
                cur.add(next[0]);
                dgrees[next[0]] ++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < dgrees.length; i++) {
            if (dgrees[i] == 0)
                queue.offer(i);
        }
        int count = 0;// 统计最终能修完的总课程数
        while (!queue.isEmpty()) {
            Integer curCourse = queue.poll();
            count ++;
            if (count == numCourses)
                return true;
            if (map.containsKey(curCourse)) {
                List<Integer> list = map.get(curCourse);
                for(Integer next : list) {
                    dgrees[next] --;
                    if (dgrees[next] == 0) {
                        queue.offer(next);
                    }
                }
            }else {

            }
        }
        return count == numCourses;
    }
}
