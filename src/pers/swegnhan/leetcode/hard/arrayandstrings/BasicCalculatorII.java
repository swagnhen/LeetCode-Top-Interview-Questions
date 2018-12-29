package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.*;

public class BasicCalculatorII {

    public static int calculate(String s) {
        int num = 0;
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> signStack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                num = num * 10 + s.charAt(i) - '0';
                if(i == s.length() - 1 || s.charAt(i + 1) > '9' || s.charAt(i + 1) < '0') {
                    numStack.add(num);
                    num = 0;
                }
            }
            else{
                if(s.charAt(i) != ' ')
                    signStack.add(s.charAt(i));
            }
        }
        char sign = ' ';
        int size = signStack.size();
        int a = 0, b = 0;
        for(int i = 0; i < size; i++){
            sign = signStack.remove();
            a = numStack.remove();
            b = numStack.remove();
            switch (sign){
                case '+':
                    signStack.add('+');
                    numStack.add(a);
                    if(i == size - 1)
                        numStack.add(b);
                    else
                        numStack.push(b);
                    break;
                case '-':
                    signStack.add('-');
                    numStack.add(a);
                    if(i == size - 1)
                        numStack.add(b);
                    else
                        numStack.push(b);
                    break;
                case '*':
                    if(i == size - 1)
                        numStack.add(a * b);
                    else
                        numStack.push(a * b);
                    break;
                case '/':
                    if(i == size - 1)
                        numStack.add(a / b);
                    else
                        numStack.push(a / b);
                    break;
            }
        }
        while(!signStack.isEmpty()){
            sign = signStack.remove();
            a = numStack.remove();
            b = numStack.remove();
            switch (sign){
                case '+':
                    numStack.push(a + b);
                    break;
                case '-':
                    numStack.push(a - b);
                    break;
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args){
        System.out.println(calculate("0-2147483647"));
    }

}
