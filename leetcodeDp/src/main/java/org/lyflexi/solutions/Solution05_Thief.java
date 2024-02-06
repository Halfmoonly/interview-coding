package org.lyflexi.solutions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/2/6 10:09
 */

/*
步长只能是2，不能是1
* f(x) = Math.max(f(x-2)+nums[x],f(x-1))
*


打家劫舍：
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



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
public class Solution05_Thief {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(rob(array));

    }
//    public static int rob(int[] nums) {
//
//        int n = nums.length;
//
//        if (n==0){
//            return 0;
//        }
//        if (n==1){
//            return nums[0];
//        }
//
//        if (n==2){
//            return Math.max(nums[0],nums[1]);
//        }
//
//        int x = nums[0],y=Math.max(nums[0],nums[1]),z=0;
//        //不要求爬出楼梯,大部分都是这种情况
//        for (int i = 0; i < n-2; i++) {
//            z=Math.max(x+nums[i+2],y);
//            x = y;
//            y=z;
//        }
//
//        return z;
//    }
/*初始化一维的dp数组，可以保存所有的dp情况,最后只返回dp最后一个元素即可*/
    public static int rob(int[] nums) {

        int n = nums.length;

        if (n==0){
            return 0;
        }
        if (n==1){
            return nums[0];
        }

        if (n==2){
            return Math.max(nums[0],nums[1]);
        }



        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        //不要求爬出楼梯,大部分都是这种情况
        for (int i = 0; i < n-2; i++) {

            dp[i+2] = Math.max(dp[i]+nums[i+2], dp[i+1]);

        }

        return dp[n-1];
    }
}
