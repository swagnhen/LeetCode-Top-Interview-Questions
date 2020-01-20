package pers.swegnhan.leetcode.hard.backtracking.WildcardMatching;

class SolutionPlus{

    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

}

public class Solution {

    public boolean isMatchStep(String s, String p, int spos, int ppos){
        if(spos == s.length() - 1 && ppos == p.length() - 1
                && (s.charAt(spos) == p.charAt(ppos) || p.charAt(ppos) == '?' || p.charAt(ppos) == '*'))
            return true;
        while(spos < s.length() && ppos < p.length()){
            if(p.charAt(ppos) == '*'){
                for(int i = ppos + 1; i < p.length() && p.charAt(i) == '*'; i++)
                    ppos++;
                if(p.charAt(ppos) == '*' && ppos == p.length() - 1)
                    return true;
                boolean result = false;
                while(ppos + 1 < p.length() && spos < s.length()){
                    if(s.charAt(spos) == p.charAt(ppos + 1) || p.charAt(ppos + 1) == '?' || p.charAt(ppos + 1) == '*')
                        result = isMatchStep(s, p, spos, ppos + 1);
                    if(result)
                        return result;
                    spos++;
                }
            }
            else if(s.charAt(spos) == p.charAt(ppos) || p.charAt(ppos) == '?'){
                spos++;
                ppos++;
            }
            else
                return false;
        }
        if(spos < s.length())
            return false;
        if(ppos < p.length()){
            for(int i = ppos; i < p.length(); i++){
                if(p.charAt(i) != '*')
                    return false;
            }
        }
        return true;
    }

    public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0)
            return true;
        if(p.length() == 0)
            return false;
        if(s.length() == 0){
            for(int i = 0; i < p.length(); i++)
                if(p.charAt(i) != '*')
                    return false;
            return true;
        }
        return isMatchStep(s, p, 0, 0);
    }

    public static void main(String[] args) {
        SolutionPlus solution = new SolutionPlus();
        System.out.println(solution.isMatch("mississippi", "m?*ss*???*i*pi"));
    }

}
