package org.lyflexi.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/2/3 21:27
 */
public class Solution01_TwoNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(scanner.nextLine());

        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }



    public static int[] twoSum(int[] nums, int target) {
        int len  = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int pair = target-nums[i];
            if (map.containsKey(pair)){
                return new int[]{map.get(pair),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
