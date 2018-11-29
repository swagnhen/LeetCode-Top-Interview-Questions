package pers.swegnhan.leetcode.medium.treesandgraphs;

import java.util.*;

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) { val = x; }

    TreeNode(List<String> args){
        val = Integer.valueOf(args.get(0));
        if (args.size() != 1){
            left = new TreeNode(args.subList(1, (args.size() - 1) / 2 + 1));
            right = new TreeNode(args.subList((args.size() - 1) / 2 + 1, args.size()));
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>(), subQueue = new LinkedList<>();
        queue.add(this);
        while(!queue.isEmpty()){
            while(!queue.isEmpty()) {
                TreeNode temp = queue.remove();
                result.append(temp.val);
                result.append(' ');
                if(temp.left != null)
                    subQueue.add(temp.left);
                if(temp.right != null)
                    subQueue.add(temp.right);
            }
            result.append('\n');
            while(!subQueue.isEmpty())
                queue.add(subQueue.remove());
        }
        return result.toString();
    }

}

public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if(root != null)
            stack.push(root);
        while(stack.isEmpty() == false){
            TreeNode temp = stack.peek();
            if(temp.left != null){
                stack.push(temp.left);
                temp.left = null;
            }
            else{
                result.add(temp.val);
                stack.pop();
                if(temp.right != null)
                    stack.push(temp.right);
            }
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode test = new TreeNode(1);
        test.right = new TreeNode(2);
        test.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(test));
    }

}
