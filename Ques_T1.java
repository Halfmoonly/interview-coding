package org.lyflexi.me;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*滑动窗口：阿里巴巴找黄金宝箱(V)*/
public class Ques_T1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(in.nextLine());
        System.out.println(maxWindows(nums,k));
        return;
    }

    private static int maxWindows(int[] nums, int k) {
        int rst=0,sum=0,n=nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <k; i++) {
            sum +=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (int i = k; i < n; i++) {
            if (map.size()==k){
                rst = Math.max(rst,sum);
            }
            sum += nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);


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
            // 右指针右移
            sum += nums[i];
            // 左指针右移
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