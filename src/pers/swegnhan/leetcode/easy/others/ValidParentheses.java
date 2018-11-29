package pers.swegnhan.leetcode.easy.others;

import java.util.*;

public class ValidParentheses {

    public static boolean isValid(String s) {
        char[] test = s.toCharArray();
        LinkedList<Character> characters = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            switch (test[i]){
                case '(':
                    characters.push('(');
                    break;
                case '[':
                    characters.push('[');
                    break;
                case '{':
                    characters.push('{');
                    break;
                case ')':
                    if(characters.isEmpty() || characters.pop() != '(')
                        return false;
                    break;
                case ']':
                    if(characters.isEmpty() || characters.pop() != '[')
                        return false;
                    break;
                case '}':
                    if(characters.isEmpty() || characters.pop() != '{')
                        return false;
                    break;
            }
        }
        if(characters.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        System.out.println(isValid("((())"));
    }

}
