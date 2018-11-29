package pers.swegnhan.leetcode.easy.trees;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueStep = new LinkedList<>();
        TreeNode temp = null;
        int depth = 0;
        if(root != null)
            queue.add(root);
        while(queue.size() > 0){
            result.add(new LinkedList<>());
            while(queue.size() > 0){
                temp = queue.remove();
                result.get(depth).add(temp.val);
                if(temp.left != null)
                    queueStep.add(temp.left);
                if(temp.right != null)
                    queueStep.add(temp.right);
            }
            while(queueStep.size() > 0)
                queue.add(queueStep.remove());
            depth++;
        }
        return result;
    }

    public static void main(String[] args){
        LinkedList<Integer> test = new LinkedList<>();
        test.add(null);
        System.out.println("end");
    }

}
