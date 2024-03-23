package org.lyflexi.solutions.tree;

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
public class Solution06_TreeDepthByQueue {
/*
在 Java 中，LinkedList 类实现了 Queue 接口，因此它可以用作队列。LinkedList 类提供了两种方法来将元素添加到队列中：add 和 offer。它们之间的主要区别在于对于已满的队列的处理方式：

add(E e) 方法：
如果队列的容量已满，在尝试将元素添加到队列时，add 方法会抛出 IllegalStateException 异常。
这个方法通常在队列不会满的情况下使用，如果队列满了就会抛出异常。

offer(E e) 方法：
如果队列的容量已满，在尝试将元素添加到队列时，offer 方法会返回 false，表示添加失败。
这个方法通常用于需要检查队列是否已满的情况下，因为它不会抛出异常。
在使用 LinkedList 作为队列时，一般推荐使用 offer 方法，因为它提供了更好的错误处理机制，避免了在队列满时抛出异常的情况。*/

    public int calculateDepth(TreeNode root) {

        if (root==null){
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();//链表结构的队列在Java中就是LinkedList,不需要指定初始化容量
        queue.offer(root);

        int hight = 0;

        while (!queue.isEmpty()){//每次循环代表当前的一层

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                //添加下一层节点
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!= null){
                    queue.offer(node.right);
                }

            }
            hight++;
        }
        return hight;

    }
}
