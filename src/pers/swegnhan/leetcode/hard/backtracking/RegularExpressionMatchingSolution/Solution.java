package pers.swegnhan.leetcode.hard.backtracking.RegularExpressionMatchingSolution;

public class Solution {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int i = 0, j = 0;
        while(i < ss.length && j < ps.length){
            if(ss[i] != ps[j]){
                if(ps[j] == '.' && (j < ps.length - 1 && ps[j + 1] != '*' || j == ps.length - 1)){ }
                else if(ps[j] == '.' && j < ps.length - 1 && ps[j + 1] == '*'){
                    while(i <= ss.length){
                        if(isMatch(s.substring(i), p.substring(j+2)))
                            return true;
                        i++;
                    }
                    return false;
                }
                else if(j < ps.length - 1 && ps[j + 1] == '*') {
                    i--;
                    j++;
                }
                else if(ps[j] == '*'){
                    if(j == ps.length - 1){
                        while(i < ss.length) {
                            if (ss[i] != ps[j - 1])
                                return false;
                            i++;
                        }
                        return true;
                    }
                    int base = i - 1;
                    if(isMatch(s.substring(base), p.substring(j+1)))
                        return true;
                    while(i == ss.length || i < ss.length && ss[i - 1] == ss[base]){
                        if(isMatch(s.substring(i), p.substring(j+1)))
                            return true;
                        i++;
                    }
                    return false;
                }
                else
                    break;
            }
            i++;
            j++;
        }
        if(i == ss.length){
            if(j == ps.length)
                return true;
            else if(j < ps.length && ps[j] == '*'){
                for(;j < ps.length; j += 2)
                    if (ps[j] != '*')
                        break;
                if(j - 1 == ps.length ||
                    i > 0 && j == ps.length && (ps[j - 1] == ss[i - 1] || ps[j - 1] == '.'))
                    return true;
                else
                    return false;
            }
            else if(j + 1 < ps.length && ps[j + 1] == '*')
            for(;j + 1 < ps.length; j += 2)
                if (ps[j + 1] != '*')
                    break;
            if(j >= ps.length)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("c","c*."));
    }
}
