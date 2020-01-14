package pers.swegnhan.leetcode.hard.treesandgraphs;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeMaximumPathSum {

    private static int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode test1) {
        max = Integer.MIN_VALUE;
        maxPathSumStep(test1);
        return max;
    }

    public int maxPathSumStep(TreeNode root) {
        if(root == null)
            return 0;
        int leftPathValue = Math.max(0, maxPathSumStep(root.left));
        int rightPathValue = Math.max(0, maxPathSumStep(root.right));
        max = Math.max(max, leftPathValue + rightPathValue + root.val);
        return Math.max(leftPathValue, rightPathValue) + root.val;
    }

    public static void main(String[] args){
        /*test 1*/
        TreeNode test1  = new TreeNode(-10);
        test1.left = new TreeNode(9);
        test1.right = new TreeNode(20);
        test1.right.left = new TreeNode(15);
        test1.right.right = new TreeNode(7);
        
        /*test 2*/
        TreeNode test2  =  new TreeNode(1);
        test2.left = new TreeNode(2);

        /*test 3*/
        TreeNode test3  =  new TreeNode(2);
        test3.left = new TreeNode(-1);

        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(test3));
    }

}
