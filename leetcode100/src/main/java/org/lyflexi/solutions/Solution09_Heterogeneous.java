package org.lyflexi.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/1/19 10:55
 */
public class Solution09_Heterogeneous {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();

        System.out.println(findAnagrams(s,p).toString());
    }

    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] sDict = new int[26];
        int[] pDict = new int[26];
        //初始化双方的字典
        for (int i = 0; i < p.length() ; i++) {
            sDict[s.charAt(i)-'a']++;
            pDict[p.charAt(i)-'a']++;
        }
//        //初始化比较
//        if (Arrays.equals(sDict,pDict))
//            answer.add(0);
        //开始滑动窗口，左边界从0到sLen-pLen
        for (int i = 0; i < s.length()-p.length(); i++) {
            if (Arrays.equals(sDict,pDict)){
                answer.add(i);
            }
            //滑动左窗口
            sDict[s.charAt(i)-'a']--;
            //滑动右窗口
            sDict[s.charAt(i+p.length())-'a']++;

        }
        if (Arrays.equals(sDict, pDict))
            answer.add(s.length()-p.length());
        return answer;
    }
}
