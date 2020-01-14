package pers.swegnhan.leetcode.hard.treesandgraphs.WordLadder;

import java.util.*;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> stepWordSet = new HashSet<>(), visitedWordSet = new HashSet<>(), candidateWordSet = new HashSet<>(wordList);
        int step = 1;
        stepWordSet.add(beginWord);
        while (!stepWordSet.isEmpty()) {
            if (stepWordSet.contains(endWord))
                return step;
            Set<String> tempWordSet = new HashSet<>();
            for (String word : stepWordSet) {
                for (String candidateWord : candidateWordSet) {
                    if (!visitedWordSet.contains(candidateWord) && isNeighbouring(word, candidateWord)) {
                        tempWordSet.add(candidateWord);
                        visitedWordSet.add(candidateWord);
                    }
                }
            }
            step++;
            stepWordSet = tempWordSet;
        }
        return 0;
    }

    public boolean isNeighbouring(String s1, String s2) {
        int different = 0;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                different++;
        }
        if (different <= 1)
            return true;
        else
            return false;
    }

}
