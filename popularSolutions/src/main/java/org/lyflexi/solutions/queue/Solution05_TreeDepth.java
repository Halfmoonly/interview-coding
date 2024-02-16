package org.lyflexi.solutions.queue;

import org.lyflexi.solutions.tree.structDef.TreeNode;

import java.util.LinkedList;

/**
 * @Author: ly
 * @Date: 2024/2/15 18:22
 */

/*
*
LCR 175. 计算二叉树的深度
某公司架构以二叉树形式记录，请返回该公司的层级数。
*
*
* */
public class Solution05_TreeDepth {


    public int calculateDepth(TreeNode root) {

        if (root==null){
            return 0;
        }
//java中的队列有两种分别是ArrayList和Linkedlist，常常使用LinkedList
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int hight = 0;

        while (!queue.isEmpty()){//每次循环代表当前的一层

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                //添加下一层节点
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!= null){
                    queue.add(node.right);
                }

            }
            hight++;
        }
        return hight;

    }
}
