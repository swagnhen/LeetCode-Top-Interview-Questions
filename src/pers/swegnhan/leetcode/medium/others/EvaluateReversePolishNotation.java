package pers.swegnhan.leetcode.medium.others;

import java.util.*;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        int tempA = 0, tempB = 0;
        for(String input : tokens){
            switch (input){
                case "+":
                    tempA = stack.pop();
                    tempB = stack.pop();
                    stack.push(tempA + tempB);
                    break;
                case "-":
                    tempA = stack.pop();
                    tempB = stack.pop();
                    stack.push(tempB - tempA);
                    break;
                case "*":
                    tempA = stack.pop();
                    tempB = stack.pop();
                    stack.push(tempA * tempB);
                    break;
                case "/":
                    tempA = stack.pop();
                    tempB = stack.pop();
                    stack.push(tempB / tempA);
                    break;
                default:
                    stack.push(Integer.valueOf(input));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        System.out.println(evalRPN(new String[]{
                "2", "1", "+", "3", "*"
        }));
    }

}
