package org.lyflexi.solutions.stack_pushandpop;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: ly
 * @Date: 2024/2/20 11:49
 */

/*
* LCR 105. 岛屿的最大面积
给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。
一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
*
* 示例 1:
输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
输出: 6
解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
*
示例 2:
输入: grid = [[0,0,0,0,0,0,0,0]]
输出: 0
* */
public class Solution04_MaxIsland {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int [][] grid = new int[100][100];
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            if ("".equals(s)){
                break;
            }
            int[] line = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();

            grid[i] = line;
            i++;
        }

        System.out.println(maxAreaOfIsland(grid));

    }
    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int innerCount = 0;

                Stack<Integer> stacki = new Stack<Integer>();
                Stack<Integer> stackj = new Stack<Integer>();
                stacki.push(i);//栈中存储横坐标
                stackj.push(j);//栈中存储纵坐标
                while (!stacki.isEmpty()) {
                    int cur_i = stacki.pop(), cur_j = stackj.pop();
                    //边界异常处理，但是不要忘了最关键的一个条件|| grid[cur_i][cur_j] != 1，此条件不加栈是会溢出的
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    //计算岛屿面积
                    ++innerCount;
                    //避免重复计算
                    grid[cur_i][cur_j] = 0;
                    //设置好四个方位坐标用于移动
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    //将四个方位坐标添加到各自的栈中
                    for (int index = 0; index != 4; ++index) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        stacki.push(next_i);
                        stackj.push(next_j);
                    }
                }
                ans = Math.max(ans, innerCount);
            }
        }
        return ans;
    }
}
