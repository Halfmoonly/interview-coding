package org.lyflexi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/3/26 17:46
 */

/*
*
* //删除 strList 中包含 ch 的所有元素
public static void remove(List<String> strList, char ch) {
    //TODO: implement it
}


示例:
ch='a'
strList={"abc", "abd", "bcd"}

执行之后
strList={"bcd"}*/
public class TTTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abd");
        list.add("bcd");
        remove(list,'a');
        System.out.println(list.toString());

    }

    public static void remove(List<String> strList, char ch) {
        List<String> answer = new ArrayList<>();
        //TODO: implement it
        for (String s:strList){
//            int n = s.length();
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < n; i++) {
//                if (s.charAt(i) != ch){
//                    sb.append(s.charAt(i));
//                }
//            }
//            if ()



        }
    }

}