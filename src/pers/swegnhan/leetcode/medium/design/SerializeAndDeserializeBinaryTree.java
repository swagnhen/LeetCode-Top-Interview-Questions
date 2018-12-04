package pers.swegnhan.leetcode.medium.design;

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

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        result.append('[');
        queue.add(root);
        int size = 1;
        while(!queue.isEmpty()){
            boolean flag = false;
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < size; i++) {
                if(queue.isEmpty())
                    break;
                TreeNode treeNode = queue.remove();
                if (treeNode == null)
                    temp.append("null,");
                else {
                    flag = true;
                    temp.append(treeNode.val).append(',');
                    queue.add(treeNode.left);
                    queue.add(treeNode.right);
                }
            }
            if(flag)
                result.append(temp);
            else
                break;
            size *= 2;
        }
        if(result.charAt(result.length() - 1) == ',')
            result.deleteCharAt(result.length() - 1);
        result.append(']');
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String input = data.substring(1, data.length() - 1);
        if(input.equals(""))
            return null;
        String[] inputs = input.split(",");
        if(inputs.length == 0)
            return null;
        TreeNode root = inputs[0].equals("null")?
                null : new TreeNode(Integer.valueOf(inputs[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        int pos = 1;
        queue.add(root);
        while(pos < inputs.length){
            TreeNode temp = queue.remove();
            if(temp != null){
                temp.left = (pos < inputs.length && !inputs[pos].equals("null"))?
                        new TreeNode(Integer.valueOf(inputs[pos])) : null;
                pos++;
                temp.right = (pos < inputs.length && !inputs[pos].equals("null"))?
                        new TreeNode(Integer.valueOf(inputs[pos])) : null;
                pos++;
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return root;
    }

    public static void main(String[] args){
        TreeNode root = deserialize("[1,2,3,null,null,4,5]");
        System.out.println(root);
        System.out.println(serialize(root));
    }

}
