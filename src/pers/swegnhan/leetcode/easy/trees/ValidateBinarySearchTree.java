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

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTStep(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTStep(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.left != null && (root.left.val >= root.val || root.left.val <= min))
            return false;
        if(root.right != null && (root.right.val <= root.val || root.right.val >= max))
            return false;
        return isValidBSTStep(root.right, root.val, max)&&isValidBSTStep(root.left, min, root.val);
    }

}
