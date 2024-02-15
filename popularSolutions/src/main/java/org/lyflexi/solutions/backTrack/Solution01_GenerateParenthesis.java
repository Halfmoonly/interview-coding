package org.lyflexi.solutions.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/2/15 20:16
 */

/*
* 22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
*
示例 2：
输入：n = 1
输出：["()"]

*
*
在回溯算法中，通常建议不要在递归调用中直接使用 ++ 操作符来修改变量的值，会产生预期之外的错误
举个例子来说，假设有一个简单的回溯问题，我们需要在一个数组中放置数字，每次放置一个数字后进行递归调用，然后在回溯时需要将放置的数字从数组中删除。如果我们在递归调用中使用 ++ 操作符来移动数组的索引，那么在递归返回时，索引值已经被修改了，可能不再指向我们放置数字的位置，从而导致错误的结果。

* */
public class Solution01_GenerateParenthesis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(generateParenthesis(n));
    }


    public static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();//StringBuilder的拼接效率会更高
        ArrayList<String> answer = new ArrayList<>();
        backTrace(0,0,sb,n,answer);
        return answer;
    }


//    “组合问题”，DFS回溯
    private static void backTrace(int open, int close, StringBuilder sb,int maxPairs,List<String> answer){

        if (sb.length()==2*maxPairs){
            answer.add(sb.toString());
            return;//结束当前递归调用
        }



//        1.放置左括号,当左括号数量小于最大值
        if (open<maxPairs) {
            backTrace(open+1,close,sb.append('('),maxPairs,answer);//写长一些可以清楚的看到变化的参数
            sb.deleteCharAt(sb.length() - 1);//为了回溯，当前递归退栈之后要恢复sb的状态至递归之前
        }

//        2.放置右括号，当左括号数量大于右括号的数量
        if (open>close){
            backTrace(open,close+1,sb.append(')'),maxPairs,answer);
            sb.deleteCharAt(sb.length() - 1);
        }

//        很有可能上述两个分支条件都同时满足，那么deleteCharAt需要连续触发两次，因此deleteCharAt不能写在此处
    }

}
