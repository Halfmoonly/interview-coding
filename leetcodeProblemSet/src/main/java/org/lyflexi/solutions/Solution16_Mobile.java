package org.lyflexi.solutions;

import java.util.*;

/**
 * @Author: ly
 * @Date: 2024/2/15 10:11
 */
public class Solution16_Mobile {


    public static void main(String[] args) {

    }
    public List<String> letterCombinations(String digits) {
        ArrayList<String> answer = new ArrayList<>();
        if ("".equals(digits)) {
            answer.add("");
        }

        int n = digits.length();

        HashMap<Character, Character> letterToDigit = new HashMap<>();
        letterToDigit.put('a','2');
        letterToDigit.put('b','2');
        letterToDigit.put('c','2');
        letterToDigit.put('d','3');
        letterToDigit.put('e','3');
        letterToDigit.put('f','3');
        letterToDigit.put('g','4');
        letterToDigit.put('h','4');
        letterToDigit.put('i','4');
        letterToDigit.put('j','5');
        letterToDigit.put('k','5');
        letterToDigit.put('l','5');
        letterToDigit.put('m','6');
        letterToDigit.put('n','6');
        letterToDigit.put('o','6');
        letterToDigit.put('p','7');
        letterToDigit.put('q','7');
        letterToDigit.put('r','7');
        letterToDigit.put('s','7');
        letterToDigit.put('t','8');
        letterToDigit.put('u','8');
        letterToDigit.put('v','8');
        letterToDigit.put('w','9');
        letterToDigit.put('x','9');
        letterToDigit.put('y','9');
        letterToDigit.put('z','9');





        int combianCounts = 1;
        for (int i = 0; i < n; i++) {
            char c = digits.charAt(i);
            int innerCount = 0;
            for (Map.Entry<Character,Character> entry:letterToDigit.entrySet()){

                if (entry.getValue().equals(c)){
                    innerCount++;
                }
            }
            combianCounts = combianCounts*innerCount;
        }


        for (int i = 0; i < combianCounts; i++) {
            StringBuffer bf = new StringBuffer();

            answer.add(String.valueOf(bf));
        }


        return answer;

    }


}
