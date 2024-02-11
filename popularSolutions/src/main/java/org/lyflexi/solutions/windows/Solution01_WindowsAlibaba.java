package org.lyflexi.solutions.windows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
//同向移动的双指针就是滑动窗口，但是大部分情况下相向移动的双指针与滑动窗口没有任何关系
//综上，滑动窗口与双指针不能混为一谈，对于滑动窗口而言往往利用for循环就可以解题


/*滑动窗口：阿里巴巴找黄金宝箱(V)：滑动窗口
* 难度	易
题目说明	一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0-N的箱子，每个箱子上面贴有一个数字。
阿里巴巴念出一个咒语数字 k ( k<N )，找出连续 k 个宝箱数字和的最大值，并输出该最大值。
输入描述	第一行输入一个数字字串，数字之间使用逗号分隔，例如: 2,10,-3,-8,40,5。
1 ≤ 字串中数字的个数 ≤ 100000。
-10000 ≤ 每个数字 ≤10000。
第二行输入咒语数字，例如: 4，咒语数字大小小于宝箱的个数。
输出描述	连续 k 个宝箱数字和的最大值，例如: 39。
补充说明	无
------------------------------------------------------
示例
示例1
输入	2,10,-3,-8,40,5
* 4
输出	39
说明	无
*
示例2
输入	8
1
输出	8
说明	无

*
*
*
*
* */

public class Solution01_WindowsAlibaba {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(in.nextLine());
        System.out.println(maxWindows(nums,k));
        return;
    }

    /*滑动窗口，那就是数组+for循环
    * 增加条件，窗口中元素不重复*/
    private static int maxWindows(int[] nums, int k) {
        int rst=0,sum=0,n=nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <k; i++) {
            sum +=nums[i];
            //getOrDefault用于初始化Map
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (int i = k; i < n; i++) {
            if (map.size()==k){
                rst = Math.max(rst,sum);
            }
            // 右窗口右移
            sum += nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            // 左窗口右移
            sum -= nums[i-k];
            int cnt = map.get(nums[i-k]);
            if (cnt==1){
                map.remove(nums[i-k]);
            }else {
                map.put(nums[i-k],cnt-1);
            }
        }
        return rst;
    }


    /*官方题解：窗口中元素允许重复****************************************************/

/*        public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long rst = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        //比较函数需要两个参数，rst暂存函数结果，sum暂存迭代窗口
        rst = Math.max(rst, sum);
        for (int i = k; i < n; i++) {
            // 右窗口右移
            sum += nums[i];
            // 左窗口右移
            sum -= nums[i - k];
            rst = Math.max(rst, sum);
        }
        return rst;
    }*/


    /*官方题解：并且要求窗口中元素不重复****************************************************/
/*    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long rst = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        for (int i = k; i < n; i++) {
            //有效条件
            if (map.size() == k) {
                rst = Math.max(rst, sum);
            }

            // 右指针右移
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);


            // 左指针右移
            sum -= nums[i - k];
            int cnt = map.get(nums[i - k]);
            if (cnt == 1) {
                map.remove(nums[i - k]);
            } else {
                map.put(nums[i - k], cnt - 1);
            }
        }

        return rst;
    }*/
}