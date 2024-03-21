package org.lyflexi.solutions.tree;

import org.lyflexi.solutions.tree.structDef.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2024/2/15 12:22
 */
public class Solution03_PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> answer = new ArrayList<>();

        postOrder(answer,root);
        return answer;

    }


    private void postOrder(List<Integer> res, TreeNode node){
        if (node== null){
            return;
        }

        postOrder(res,node.left);
        postOrder(res,node.right);
        res.add(node.val);
    }
}
