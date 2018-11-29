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

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricStep(root.left, root.right);
    }

    public boolean isSymmetricStep(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        else if (left == null && right != null)
            return false;
        else if (left != null && right == null)
            return false;
        if(left.val != right.val)
            return false;
        return isSymmetricStep(left.left, right.right) && isSymmetricStep(left.right, right.left);
    }

}
