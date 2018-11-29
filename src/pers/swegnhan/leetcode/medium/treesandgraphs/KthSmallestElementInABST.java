package pers.swegnhan.leetcode.medium.treesandgraphs;

import java.util.*;

public class KthSmallestElementInABST {

    public static int kthSmallest(TreeNode root, int k) {
        TreeNode target = new TreeNode(-1);
        kthSmallestStep(root, k, 0, target);
        return target.val;
    }

    public static int kthSmallestStep(TreeNode root, int k, int num, TreeNode target) {
        if(num >= k)
            return num;
        if(root.left != null)
            num = kthSmallestStep(root.left, k, num, target);
        num++;
        if(num == k){
            target.val = root.val;
            return num;
        }
        if(root.right != null){
            return kthSmallestStep(root.right, k, num, target);
        }
        else
            return num;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(Arrays.asList("1", "2", "4", "5", "3", "6", "7"));
        System.out.println(kthSmallest(root, 1));
    }

}
