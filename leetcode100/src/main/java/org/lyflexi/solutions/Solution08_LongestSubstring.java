package org.lyflexi.solutions;

import java.util.HashMap;

/**
 * @Author: ly
 * @Date: 2024/1/16 10:36
 */
/*本题是滑动窗口：

* 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
*
示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1
*
示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*
*
*
* */
public class Solution08_LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;
        if (s==null) return 0;
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        //key是元素值，value是元素索引（右指针）
        HashMap<Character, Integer> map = new HashMap<>();
        int left = -1;
        map.put(charArray[0],0);
        answer = 1;
        for (int i = 1; i < n; i++) {
            char c = charArray[i];
            if (map.containsKey(c)){
                left = map.get(c);//更新左指针
            }
            map.put(c,i);//右指针正常迭代
            answer = Math.max(answer,i-left);
        }


        return answer;

    }
}
