package org.lyflexi.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2024/2/3 21:40
 */
public class Solution02_AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums1 = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int m = nums1.length;
        ListNode pre1 = new ListNode();
        ListNode cur1 = pre1;
        for (int i = 0; i < m; i++) {
            ListNode listNode = new ListNode(nums1[i]);
            cur1.next = listNode;
            cur1 = cur1.next;
        }

        int n = nums2.length;
        ListNode pre2 = new ListNode();
        ListNode cur2 = pre2;
        for (int i = 0; i < n; i++) {
            ListNode listNode = new ListNode(nums2[i]);
            cur2.next = listNode;
            cur2 = cur2.next;
        }

        ListNode listNode = addTwoNumbers(pre1.next, pre2.next);
        printNum(listNode);

    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //初始化假头节点，便于后续统一节点操作
        ListNode pre = new ListNode();
        //固定ansNode的头节点不动，派出手下去跟随索引
        ListNode cur = pre;
        //进位carry
        int carry = 0;
        while (l1!=null||l2!=null){

            int x = l1==null?0:l1.val;
            int y = l2==null?0:l2.val;


            int local = (x+y + carry) % 10;
            carry = (x+y + carry ) / 10;

            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }

            cur.next = new ListNode(local);
            cur = cur.next;
        }

        if (carry==1){
            cur.next = new ListNode(1);
        }


        return pre.next;
    }



    private static void printNum(ListNode trueList){
        while (trueList!=null){
            System.out.println(trueList.val);
            trueList = trueList.next;
        }
    }
}
