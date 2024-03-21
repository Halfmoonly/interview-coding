package org.lyflexi.solutions.lineSection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/3/20 10:44
 */
/*986. 区间列表的交集
给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
返回这 两个区间列表的交集 。
形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。*/


public class Solution01_Intersection {




    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length;
        int n = secondList.length;

        List<int[]> answer = new ArrayList<>();
        for (int[] a:firstList){
            for (int[] b : secondList){
                //第一种情况, 寻找下一个b
                if (b[1]<a[0]){
                    continue;
                }
                //第二种情况，寻找下一个a
                if (a[1]<b[0]){
                    break;
                }
                //第三种情况，a完全包裹b，结果就是b
                if (a[0]<b[0]&&a[1]>b[1]){
                    answer.add(new int[]{b[0],b[1]});
                }else if (b[0]<a[0]&&b[1]>a[1]){//第四种情况，b完全包裹a，结果就是a
                    answer.add (new int[]{a[0],a[1]});
                }else {//第五种情况，a和b交叉,返回最大的start和最小的end
                    answer.add(new int[]{Math.max(a[0],b[0]),Math.min(a[1],b[1])});
                }
            }
        }
        //套了对象的集合answer，就相当于二维数组
        return answer.toArray(new int[answer.size()][]);
    }

//    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
//        int m = firstList.length;
//        int n = secondList.length;
//        //二维数组相当于套了对象的集合，但是我不知道集合最终的大小，数组开辟后如果没用到返回结果不会忽略
//        int[][] answer = new int[m+n][];
//        int index = 0;
//        for (int[] a:firstList){
//            for (int[] b : secondList){
//                //第一种情况, 寻找下一个b
//                if (b[1]<a[0]){
//                    continue;
//                }
//                //第二种情况，寻找下一个a
//                if (a[1]<b[0]){
//                    break;
//                }
//                //第三种情况，a完全包裹b，结果就是b
//                if (a[0]<b[0]&&a[1]>b[1]){
//                    answer[index] = new int[]{b[0],b[1]};
//                    index++;
//                }else if (b[0]<a[0]&&b[1]>a[1]){//第四种情况，b完全包裹a，结果就是a
//                    answer[index] = new int[]{a[0],a[1]};
//                    index++;
//                }else {//第五种情况，a和b交叉,返回最大的start和最小的end
//                    answer[index] = new int[]{Math.max(a[0],b[0]),Math.min(a[1],b[1])};
//                    index++;
//                }
//            }
//        }
//        return answer;
//    }
}
