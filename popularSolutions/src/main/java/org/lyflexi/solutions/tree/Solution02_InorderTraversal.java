package org.lyflexi.solutions.tree;

import org.lyflexi.solutions.tree.structDef.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/2/15 11:39
 */
public class Solution02_InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> answer = new ArrayList<>();
        inOrder(answer,root);
        return answer;

    }

    private void inOrder(List<Integer> res , TreeNode node){
        if (node == null ){
            return;
        }

        inOrder(res,node.left);
        res.add(node.val);
        inOrder(res,node.right);
    }

}
