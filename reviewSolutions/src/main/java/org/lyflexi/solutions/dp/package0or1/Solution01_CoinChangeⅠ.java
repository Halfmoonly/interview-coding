package org.lyflexi.solutions.dp.package0or1;

/**
 * @Author: ly
 * @Date: 2024/2/20 13:14
 */

/*
* LCR 103. 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
* 如果没有任何一种硬币组合能组成总金额，返回 -1。
你可以认为每种硬币的数量是无限的。

示例 1：
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
*
示例 2：
输入：coins = [2], amount = 3
输出：-1
*
示例 3：
输入：coins = [1], amount = 0
输出：0
*
示例 4：
输入：coins = [1], amount = 1
输出：1
*
示例 5：
输入：coins = [1], amount = 2
输出：2

* */
public class Solution01_CoinChangeⅠ {

    //f(target) = Min(f(target-coins[0]),f(target-coins[1])...,f(target-coins[n-1]))+1
    //= Min(f(target-coins[0])+1,f(target-coins[1])+1...,f(target-coins[n-1])+1)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //金币的数量不会超过amount，默认全置为amount+1
        for(int i = 0;i<dp.length;i++){
            dp[i] = coins.length+1;
        }

        int n = coins.length;

        //凑满0不需要金币，因此是0
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if(i-coins[j]>=0){
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                }
            }
        }


        return dp[amount]==amount+1?-1:dp[amount];
    }
}
