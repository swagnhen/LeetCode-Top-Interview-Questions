package pers.swegnhan.leetcode.medium.backtracking;

import java.util.*;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<>();
        generateParenthesisStep(result, "(", n, 1, 0);
        return result;
    }

    public static void generateParenthesisStep(LinkedList<String> result, String factor, int n, int deepl, int deepr){
        if(deepl == n){
            for(int i = deepr; i < n; i++)
                factor = factor + ')';
            result.add(factor);
            return;
        }
        generateParenthesisStep(result, factor + '(', n, deepl + 1, deepr);
        if(deepl > deepr)
            generateParenthesisStep(result, factor + ')', n, deepl, deepr + 1);
    }

    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }

}
