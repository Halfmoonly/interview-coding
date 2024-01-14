package org.lyflexi.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/1/14 11:02
 */
public class Solution6_ThreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(threeSum(array));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        if (nums == null) return answer;//return null

        int n = nums.length;

        if (n<3) return answer;//return null

        Arrays.sort(nums);

        if (nums[0]>0) return answer;//return null

        for (int i = 0; i < n; i++) {

            int left = i+1;
            int right =n-1;

            //nums[i]这样循环去重是错误的
//            if (i<n-1&&nums[i]==nums[i+1]) continue;
            // nums[i]循环去重的正确逻辑如下，与下面双指针的去重逻辑相反
            //要保留相邻nums[i]和nums[i+1]相等，且作为同一个三元组的情况
            if(i > 0 && nums[i] == nums[i-1]) continue;

            while (left<right){

                int sum = nums[i]+nums[left]+nums[right];
                if (sum==0){
                    answer.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1]) left++;//循环去重,向右走
                    while(left<right&&nums[right]==nums[right-1]) right--;//循环去重,向左走
                    left++;
                    right--;
                }
                else if (sum<0) {
                    left++;
                }else{
                    right--;
                }
            }

        }
        return answer;

    }
}
