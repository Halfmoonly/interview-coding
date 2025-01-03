package org.lyflexi.solutions.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/2/6 10:09
 */

/*
198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



示例 1：
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2：
输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
* */
public class Solution07_ThiefAndEarnⅢ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(rob(array));

    }

/*初始化一维的dp数组，可以保存所有的dp情况,最后只返回dp最后一个元素即可*/
    public static int rob(int[] nums) {

        int n = nums.length;

        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0],nums[1]);

        //数学公式f(x) = Math.max(f(x-2)+nums[x],f(x-1))
        for (int i = 3; i < n+1; i++) {
            //代码公式
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }

        return dp[n];
    }
}
