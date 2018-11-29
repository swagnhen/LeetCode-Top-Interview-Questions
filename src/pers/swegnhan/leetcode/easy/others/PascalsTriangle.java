package pers.swegnhan.leetcode.easy.others;

import java.util.*;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++){
            result.add(new ArrayList<>(i + 1));
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i)
                    result.get(i).add(1);
                else
                    result.get(i).add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(generate(5));
    }

}
