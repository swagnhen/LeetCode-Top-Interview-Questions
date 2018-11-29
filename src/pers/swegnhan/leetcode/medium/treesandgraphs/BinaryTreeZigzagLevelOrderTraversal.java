package pers.swegnhan.leetcode.medium.treesandgraphs;

import jdk.nashorn.api.tree.Tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.add(root);
        for(int i = 0; queue.isEmpty() != true; i++){
            TreeNode tempn = null;
            result.add(new LinkedList<>());
            LinkedList<TreeNode> tempq = new LinkedList<>();
            if(i % 2 == 0){
                while(queue.isEmpty() != true){
                    tempn = queue.remove();
                    result.get(i).add(tempn.val);
                    if (tempn.left != null)
                        tempq.push(tempn.left);
                    if(tempn.right != null)
                        tempq.push(tempn.right);
                }
            }
            else{
                while(queue.isEmpty() != true){
                    tempn = queue.remove();
                    result.get(i).add(tempn.val);
                    if (tempn.right != null)
                        tempq.push(tempn.right);
                    if (tempn.left != null)
                        tempq.push(tempn.left);
                }
            }
            while (tempq.isEmpty() != true) {
                tempn = tempq.pop();
                queue.add(tempn);
            }
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(Arrays.asList("1", "2", "4", "5", "3", "6", "7"));
        System.out.println(zigzagLevelOrder(root));
    }

}
