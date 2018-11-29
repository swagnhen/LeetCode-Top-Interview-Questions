package pers.swegnhan.leetcode.medium.treesandgraphs;

import java.util.*;

class TreeLinkNode {

    int val;

    TreeLinkNode left, right, next;

    TreeLinkNode(int x) { val = x; }

    TreeLinkNode(List<String> args){
        val = Integer.valueOf(args.get(0));
        if (args.size() != 1){
            left = new TreeLinkNode(args.subList(1, (args.size() - 1) / 2 + 1));
            right = new TreeLinkNode(args.subList((args.size() - 1) / 2 + 1, args.size()));
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        LinkedList<TreeLinkNode> queue = new LinkedList<>(), subQueue = new LinkedList<>();
        queue.add(this);
        while(!queue.isEmpty()){
            while(!queue.isEmpty()) {
                TreeLinkNode temp = queue.remove();
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

public class PopulatingNextRightPointersInEachNode {

    public static void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        if(root != null)
            queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode temp = queue.remove();
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
            for(int i = 1; i < size; i++){
                temp.next = queue.remove();
                if(temp.next.left != null)
                    queue.add(temp.next.left);
                if(temp.next.right != null)
                    queue.add(temp.next.right);
                temp = temp.next;
            }
        }
    }

    public static void connectPlus(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode up = root, down = null;
        while(up.left != null){
            down = up;
            while(down != null){
                down.left.next = down.right;
                if(down.next != null)
                    down.right.next = down.next.left;
                down = down.next;
            }
            up = up.left;
        }
    }

    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(Arrays.asList("1", "2", "4", "5", "3", "6", "7"));
        connect(root);
        System.out.println(root);
    }

}
