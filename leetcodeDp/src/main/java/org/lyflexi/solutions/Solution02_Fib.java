package org.lyflexi.solutions;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/2/5 13:37
 */

/*斐波那契数: dp：  f(x) = f(x-1)+f(x-2),求f(x),   已知初始条件为f(0)=1，f(1)=1

斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给定 n ，请计算 F(n) 。

示例 1：
输入：n = 2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1

示例 2：
输入：n = 3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2

示例 3：
输入：n = 4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 */
public class Solution02_Fib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(fib(n));
    }
    public static int fib(int n) {
        if (n==0){
            return 0;
        }

        if (n==1){
            return 1;
        }

        int x = 0,y=1,z=0;
        //前面已经计算过2次，再计算n-1次即可，因为0~n总共要计算n+1个情况
        for (int i = 0; i < n-1; i++) {

            z = x+y;
            x=y;
            y=z;
        }

        return z;
    }
}
