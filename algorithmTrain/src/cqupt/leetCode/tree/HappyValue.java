package cqupt.leetCode.tree;

import java.util.List;

/**
 * @author yiLi
 * @create 2020-05-24 11:06
 * 派对的最大快乐值
 */
public class HappyValue {
    public int getMaxHappy(Employee boss) {
        ResNodeHappy resNodeHappy = helper(boss);
        return Math.max(resNodeHappy.noNode, resNodeHappy.yesNode);
    }

    private ResNodeHappy helper(Employee boss) {
        ResNodeHappy res = new ResNodeHappy(0, 0);
        if (boss == null)
            return res;
        int bossYes = boss.happy;
        int bossNo = 0;
        if (boss.subEmployee.isEmpty()) {
            return new ResNodeHappy(bossYes, bossNo);
        }else {
            for(Employee  employee : boss.subEmployee) {
                ResNodeHappy employeeHappy = helper(employee);
                // boss来
                bossYes += employeeHappy.noNode;
                // boss不来 那么他的员工可来可不来
                bossNo += Math.max(employeeHappy.yesNode, employeeHappy.noNode);
            }
        }
        res.yesNode = bossYes;
        res.noNode = bossNo;
        return res;
    }
}
class Employee {
    int happy;
    List<Employee> subEmployee;
}
class ResNodeHappy {
    int yesNode;
    int noNode;

    public ResNodeHappy(int yesNode, int noNode) {
        this.yesNode = yesNode;
        this.noNode = noNode;
    }
}
