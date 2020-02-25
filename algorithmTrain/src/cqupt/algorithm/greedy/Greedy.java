package cqupt.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Liyi
 * @create 2020-02-25 9:22
 * 贪心算法
 */
public class Greedy {
    public static void main(String[] args) {

        // 创建电台与对应的地区
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);
        // allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        // 创建一个list 存放已选中的电台
        ArrayList<String> selects = new ArrayList<>();
        // 定义一个临时集合 存放在遍历电台的时候，每个电台与allAreas的交集，便于后续找到交集最大的那个电台
        HashSet<String> tempSet = new HashSet<>();
        // 定义一个指向 最大key的指针maxKey
        String maxKey = null;

        // 开始遍历 while出口：allAreas里面地区为空
        while (!allAreas.isEmpty()) {
/*            // maxKey每次找到当前轮最优后就要置空
            maxKey = null;*/
            // 开始遍历电台和对应的地区broadcasts
            for(String key : broadcasts.keySet()) {
                // 每次进来一次for tempSet就要为新的
                tempSet.clear();
                // 当前这个key能覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                // 将这个电台覆盖的地区存放到临时set
                tempSet.addAll(areas);
                // 得到tempSet与allAreas的交集
                tempSet.retainAll(allAreas);// 这个方法会将得到的交集重新赋给tempSet
                // 更新maxKey的条件:
                // 如果临时集合有东西，并且大小大于之前maxKey的大小，或者maxKey为空（第一次进的时候）
                // !!! 代码的牛逼之处：先&&再||
                // 如果tempSet.size() <= 0 就直接不进逻辑，如果>0就看maxKey是否为null，如果==null,就直接进逻辑，后面不用看
                // 提高效率！
                if (tempSet.size() > 0 && (maxKey==null
                        || tempSet.size() > broadcasts.get(maxKey).size())) {
//                    broadcasts.get(key).size() 等于 tempSet.size()
                    maxKey = key;
                }
            }
            // 出了for循环后 要判断maxKey得到了没
            if (maxKey != null) {
                // 将macKey对应的电台加入到selects中
                selects.add(maxKey);
                // 然后从allAreas中去除maxKey对应的地区
                allAreas.removeAll(broadcasts.get(maxKey));
                // 将maxKey置空，下轮再用   每次进while循环时候置空也是一样的，得到一个maxKey之后肯定接着进while
                maxKey = null;
            }
        }
        System.out.println("得到的选择结果是" + selects);// [K1,K2,K3,K5]
    }
}
