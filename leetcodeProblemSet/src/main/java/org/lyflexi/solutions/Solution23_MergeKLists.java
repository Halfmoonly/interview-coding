package org.lyflexi.solutions;

import org.lyflexi.solutions.structDef.ListNode;

/**
 * @Author: ly
 * @Date: 2024/2/16 17:21
 */

/*
* 23. 合并 K 个升序链表
给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
*
*
*
* */
public class Solution23_MergeKLists {
//    我们可以想到一种最朴素的方法：循环调用mergeTwoLists，返回值即是合并后的结果
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if (n==1){
            return lists[0];
        }

        if (n>=2){
            ListNode node = mergeTwoLists(lists[0], lists[1]);

            for (int i = 2; i < n; i++) {
                node = mergeTwoLists(node, lists[i]);
            }
            return node;
        }

        return null;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);

        ListNode cur = dummy;

        while(list1!=null&&list2!=null){
            ListNode node;
            if (list1.val>list2.val){
                node = new ListNode(list2.val);
                list2 = list2.next;

            }else{
                node = new ListNode(list1.val);
                list1 = list1.next;
            }
            cur.next = node;
            cur = cur.next;
        }

        if (list1==null&&list2!=null){
            cur.next = list2;
        }

        if (list2==null&&list1!=null){
            cur.next = list1;
        }

        return dummy.next;

    }
}
