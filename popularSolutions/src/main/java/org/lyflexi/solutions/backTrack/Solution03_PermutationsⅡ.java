package org.lyflexi.solutions.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/2/16 8:21
 */


/*47. 全排列 II
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 
示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 
 */
public class Solution03_PermutationsⅡ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        boolean[] flags = new boolean[nums.length];
        Arrays.sort(nums);//对nums数组提前排序，为了支持nums[i] == nums[i - 1]判断

        dfsBackTrace(nums,answer,list,flags);

        return answer;

    }

    private static void dfsBackTrace(int[] nums, List<List<Integer>> answer, ArrayList<Integer> list,boolean[] flags) {

        int n = nums.length;
        if (list.size()==n){
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            int item = nums[i];

            //对于112，第三个分支第一层是2，此时我们对第二层约定：flags[1,0,1]为有效，flags[0,1,1]重复无效
            if (i>0&&nums[i] == nums[i - 1] && !flags[i - 1]){
                continue;
            }

            if (!flags[i]) {//对于123的纵向遍历，保证每次纵深的时候剔除已有的元素
                list.add(item);
                flags[i] = true;//表示当前元素已经使用过
                dfsBackTrace(nums,answer,list,flags);
                flags[i] = false;//表示当前元素已经恢复未使用的状态
                list.remove(list.size()-1);//回溯清除
            }

        }

    }
}


