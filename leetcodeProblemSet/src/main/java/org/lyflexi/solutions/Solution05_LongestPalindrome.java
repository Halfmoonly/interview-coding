package org.lyflexi.solutions;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/2/5 12:37
 */

/*最长回文子串：中心扩散法
给你一个字符串 s，找到 s 中最长的回文子串。
如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"
 */
public class Solution05_LongestPalindrome {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()){
            return "";
        }
        int n = s.length();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            int innerLen = 1;//innerLen暂时没用，题目要求返回回文字符串本身
            int left = i-1;
            int right = i+1;

            char centerKey = s.charAt(i);
            while(left>=0&&s.charAt(left)==centerKey){
                left--;
                innerLen++;
            }

            while(right<n&&s.charAt(right)==centerKey){
                right++;
                innerLen++;
            }

            while(left>=0&&right<n&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                innerLen+=2;
            }

            String str = s.substring(left+1,right);
            list.add(str);
        }

//        无论是min函数或者是max函数，比较器Comparator接口都要写成自然的形式
        Optional<String> maxString = list.stream().max((s1, s2) -> s1.length() - s2.length());
        return maxString.orElse("");
    }
}
