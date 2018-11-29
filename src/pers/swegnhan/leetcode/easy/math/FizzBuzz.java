package pers.swegnhan.leetcode.easy.math;

import java.util.*;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(i % 15 == 0)
                result.add("FizzBuzz");
            else if(i % 5 == 0)
                result.add("Buzz");
            else if(i % 3 == 0)
                result.add("Fizz");
            else
                result.add(Integer.toString(i));
        }
        return result;
    }

    public static void main(String[] args){

    }

}
