package pers.swegnhan.leetcode.easy.trees;

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) { val = x; }

}

public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        int maxDepth = 0;
        maxDepth = maxDepthStep(root, 0);
        return maxDepth;
    }

    public static int maxDepthStep(TreeNode root, int depth){
        if(root == null)
            return depth;
        return Math.max(maxDepthStep(root.left, depth + 1), maxDepthStep(root.right, depth + 1));
    }

    public static void main(String[] args){

    }

}
