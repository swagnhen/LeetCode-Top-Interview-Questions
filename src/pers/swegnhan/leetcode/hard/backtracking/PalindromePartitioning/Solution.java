package pers.swegnhan.leetcode.hard.backtracking.PalindromePartitioning;

import java.util.*;

class SolutionPlus{

    private boolean isPalindrome(String s){
        char[] input = s.toCharArray();
        for(int i = 0; i < s.length() / 2; i++)
            if(input[i] != input[s.length() - i - 1])
                return false;
        return true;
    }

    private void backTracking(String s, int start, List<String> crrntl, List<List<String>> rsltl){
        if(start >= s.length() && crrntl.size() > 0){
            rsltl.add(new ArrayList<>(crrntl));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s.substring(start, i + 1))){
                crrntl.add(s.substring(start, i + 1));
                backTracking(s, i + 1, crrntl, rsltl);
                crrntl.remove(crrntl.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        backTracking(s, 0, new LinkedList<>(), result);
        return result;
    }

}

public class Solution {

    private boolean isPalindrome(String s){
        char[] input = s.toCharArray();
        for(int i = 0; i < s.length() / 2; i++)
            if(input[i] != input[s.length() - i - 1])
                return false;
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        List<List<Set<List<String>>>> dp = new ArrayList<>(s.length());
        for(int i = 0; i < s.length(); i++)
            dp.add(new ArrayList<>(s.length() - i));
        for(int i = 0; i < s.length(); i++){
            Set<List<String>> dps = new HashSet<>();
            dps.add(Arrays.asList(s.substring(i, i + 1)));
            dp.get(0).add(dps);
        }
        for(int i = 1; i < s.length(); i++){
            for(int j = 0; j < s.length() - i; j++){
                Set<List<String>> step = new HashSet<>();
                for(int k = 0; k < i; k++){
                    Set<List<String>> c1 = dp.get(k).get(j);
                    Set<List<String>> c2 = dp.get(i - k - 1).get(j + k + 1);
                    for(List<String> l1 : c1){
                        for(List<String> l2 : c2){
                            List<String> stepByStep = new LinkedList<>();
                            stepByStep.addAll(l1);
                            stepByStep.addAll(l2);
                            step.add(stepByStep);
                        }
                    }
                }
                if(isPalindrome(s.substring(j, j + i + 1)))
                    step.add(Arrays.asList(s.substring(j, j + i + 1)));
                dp.get(i).add(step);
            }
        }
        result.addAll(dp.get(s.length() - 1).get(0));
        return result;
    }

    public static void main(String[] args) {
        SolutionPlus solution = new SolutionPlus();
        System.out.println(solution.partition("aab"));
    }

}
