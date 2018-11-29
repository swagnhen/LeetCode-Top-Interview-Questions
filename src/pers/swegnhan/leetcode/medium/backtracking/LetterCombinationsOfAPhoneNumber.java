package pers.swegnhan.leetcode.medium.backtracking;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return new ArrayList<>();
        Map<Character, ArrayList<Character>> map = new HashMap<>();
        map.put('2', new ArrayList(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList(Arrays.asList('w', 'x', 'y', 'z')));
        char[] input = digits.toCharArray();
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        for(int i = 0; i < input.length; i++){
            List<Character> factor = map.get(input[i]);
            int sizeR = result.size();
            for(int j = 0; j < sizeR; j++){
                String porto = result.remove();
                int sizeM = factor.size();
                for(int k = 0; k < sizeM; k++){
                    result.add(porto + factor.get(k));
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(letterCombinations("237"));
    }

}