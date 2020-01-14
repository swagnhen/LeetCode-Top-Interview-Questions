package pers.swegnhan.leetcode.hard.treesandgraphs;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int[] root = new int[M.length];
        for(int i = 0; i < root.length; i++)
            root[i] = i;
        for(int i = 0; i < root.length; i++){
            for(int j = i + 1; j < root.length; j++){
                if(M[i][j] == 1 && root[j] != root[i]){
                    for(int k = 0; k < root.length; k++){
                        if(root[k] == root[j] && k != j)
                            root[k] = root[i];
                    }
                    root[j] = root[i];
                }
            }
        }
        Set<Integer> circle = new HashSet<>();
        for(int c : root)
            circle.add(c);
        return circle.size();
    }

    public static void main(String[] args) {
        FriendCircles friendCircles = new FriendCircles();
        int[][] test = {
                {1,0,0,0,1,1,0,1,0,0,0,1,0,0,0},
                {0,1,0,0,1,0,1,0,0,0,0,0,0,0,0},
                {0,0,1,0,1,0,0,0,0,0,0,0,1,1,0},
                {0,0,0,1,0,0,0,0,0,0,0,1,1,1,0},
                {1,1,1,0,1,0,0,0,0,0,1,0,0,0,0},
                {1,0,0,0,0,1,0,0,0,1,0,0,0,0,0},
                {0,1,0,0,0,0,1,0,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,0,1},
                {0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,1,0,0,1,0},
                {1,0,0,1,0,0,0,0,0,0,0,1,1,0,0},
                {0,0,1,1,0,0,0,0,0,0,0,1,1,0,0},
                {0,0,1,1,0,0,0,0,0,0,1,0,0,1,0},
                {0,0,0,0,0,0,0,0,1,0,0,0,0,0,1}};
        System.out.println(friendCircles.findCircleNum(test));
    }

}
