package cqupt.writtenExamination.tencent;

import java.util.*;

/**
 * @author yiLi
 * @create 2020-09-06 20:40
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        res = new ArrayList<>();
        String[] strings = new String[m + 1];
        for (int i = 0; i < m + 1; i++) {
            strings[i] = sc.nextLine();
            res.add(strings[i].split(" "));
        }
        sc.close();
        HashSet<String> set = new HashSet<>();
        boolean[] visited = new boolean[m + 1];
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i)[1].equals("0")) {
                visited[i] = true;
                for (int j = 1; j < res.get(i).length; j++) {
                    set.add(res.get(i)[j]);
                }
            }
        }
        // 现在有0的那组已经全部放进去了
        for (int i = 1; i < res.size(); i++) {
            if (visited[i])
                continue;
            String[] curStr = res.get(i);
            for (int j = 1; j < curStr.length; j++) {
                if (set.contains(curStr[j])) {
                    for (int k = 1; k < curStr.length; k++) {
                        set.add(curStr[k]);
                    }
                    visited[i] = true;
                    break;
                }
            }
        }
        System.out.println(set.size());
    }
    private static List<String[]> res;
}
