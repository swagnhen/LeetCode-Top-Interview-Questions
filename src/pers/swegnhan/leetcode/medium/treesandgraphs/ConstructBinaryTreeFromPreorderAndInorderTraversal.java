package pers.swegnhan.leetcode.medium.treesandgraphs;

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

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1)
            return root;
        int pos = 1;
        for(int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                pos = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, pos + 1), Arrays.copyOfRange(inorder, 0, pos));
        root.right = buildTree(Arrays.copyOfRange(preorder, pos + 1, preorder.length), Arrays.copyOfRange(inorder, pos + 1, inorder.length));
        return root;
    }

    public static void main(String[] args){
        System.out.println(buildTree(new int[]{3,2,1,4}, new int[]{1,2,3,4}));
    }

}
