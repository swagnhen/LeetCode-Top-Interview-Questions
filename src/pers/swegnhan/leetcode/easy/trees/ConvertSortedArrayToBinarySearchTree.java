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

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        sortedArrayToBSTStep(root, nums, 0, nums.length/2 - 1, false);
        sortedArrayToBSTStep(root, nums, nums.length/2 + 1, nums.length - 1, true);
        return root;
    }

    public void sortedArrayToBSTStep(TreeNode root, int[] nums, int start, int end, boolean lr){
        if(start > end)
            return;
        TreeNode temp = new TreeNode(nums[(start + end) / 2]);
        if(!lr)
            root.left = temp;
        else
            root.right = temp;
        sortedArrayToBSTStep(temp, nums, start, (start + end) / 2 - 1, false);
        sortedArrayToBSTStep(temp, nums, (start + end) / 2 + 1, end, true);
    }

}
