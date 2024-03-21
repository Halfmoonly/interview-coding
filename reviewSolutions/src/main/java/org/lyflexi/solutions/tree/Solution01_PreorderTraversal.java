package org.lyflexi.solutions.tree;

import org.lyflexi.solutions.tree.structDef.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/2/15 11:26
 */

/*所谓神秘的DFS算法也就分为以下三种，分别是：
* 前序遍历
* 中序遍历
* 后续遍历
* */
public class Solution01_PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> answer = new ArrayList<>();

        //answer是集合指针
        preOrder(answer,root);

        return answer;

    }


    private void preOrder(List<Integer> res,TreeNode node){
        if (node==null){
            return;
        }

        res.add(node.val);
        preOrder(res,node.left);
        preOrder(res,node.right);
    }
}
