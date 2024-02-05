package org.lyflexi.solutions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/2/5 13:51
 */

/*f(x)=Math.min(f(x-1)+cost[x-1],f(x-2)+cost[x-2])，此处的f(x)即目标值，代表到第x阶的最小花费
*
* 题目要求的是爬出楼梯，因此目标对象是n+1
*
* 所以分析出初始值f(1)=0，f(2)=Math.min(cost[0],cost[1])
*
* */

/*使用最小花费爬楼梯

给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
请你计算并返回达到楼梯顶部的最低花费。


示例 1：
输入：cost = [10,15,20]
输出：15
解释：你将从下标为 1 的台阶开始。
- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
总花费为 15 。

示例 2：
输入：cost = [1,100,1,1,1,100,1,1,100,1]
输出：6
解释：你将从下标为 0 的台阶开始。
- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
总花费为 6 。*/
public class Solution04_MinCostClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] costs = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(minCostClimbingStairs(costs));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n==1){
            return 0;
        }
        if (n==2){
            return Math.min(cost[0],cost[1]);
        }

        int x = 0,y=0,z=0;
        //前面已经计算过2次，但是这道题要求爬出楼梯，目标对象是1~n+1,因此需要再计算n-1次
        for (int i = 0; i < n-1; i++) {

            z = Math.min(y+cost[i+1],x+cost[i]);
            x=y;
            y=z;
        }

        return y;
    }
}
