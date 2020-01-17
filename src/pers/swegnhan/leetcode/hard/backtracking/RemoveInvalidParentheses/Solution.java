package pers.swegnhan.leetcode.hard.backtracking.RemoveInvalidParentheses;

import java.util.*;

class SolutionPlus{
    private Set<String> validExpressions = new HashSet<String>();

    private void recurse(
            String s,
            int index,
            int leftCount,
            int rightCount,
            int leftRem,
            int rightRem,
            StringBuilder expression) {

        // If we reached the end of the string, just check if the resulting expression is
        // valid or not and also if we have removed the total number of left and right
        // parentheses that we should have removed.
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                this.validExpressions.add(expression.toString());
            }

        } else {
            char character = s.charAt(index);
            int length = expression.length();

            // The discard case. Note that here we have our pruning condition.
            // We don't recurse if the remaining count for that parenthesis is == 0.
            if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
                this.recurse(
                        s,
                        index + 1,
                        leftCount,
                        rightCount,
                        leftRem - (character == '(' ? 1 : 0),
                        rightRem - (character == ')' ? 1 : 0),
                        expression);
            }

            expression.append(character);

            // Simply recurse one step further if the current character is not a parenthesis.
            if (character != '(' && character != ')') {

                this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);

            } else if (character == '(') {

                // Consider an opening bracket.
                this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);

            } else if (rightCount < leftCount) {

                // Consider a closing bracket.
                this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
            }

            // Delete for backtracking.
            expression.deleteCharAt(length);
        }
    }

    public List<String> removeInvalidParentheses(String s) {

        int left = 0, right = 0;

        // First, we find out the number of misplaced left and right parentheses.
        for (int i = 0; i < s.length(); i++) {

            // Simply record the left one.
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                // If we don't have a matching left, then this is a misplaced right, record it.
                right = left == 0 ? right + 1 : right;

                // Decrement count of left parentheses because we have found a right
                // which CAN be a matching one for a left.
                left = left > 0 ? left - 1 : left;
            }
        }

        this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<String>(this.validExpressions);
    }
}

public class Solution {

    private List<List<String>> tailprocess(String s, int start){
        LinkedList<List<String>> result = new LinkedList<>();
        int count = 0;
        int end = s.length() - 1;
        for(int i = s.length() - 1; i >= start; i--){
            if(s.charAt(i) == ')')
                count++;
            else if(s.charAt(i) == '(')
                count--;
            if(count < 0) {
                result.push(moreleft(s, end, i));
                end = i - 1;
                count = 0;
            }
            else if(i == start && count == 0)
                result.push(Arrays.asList(s.substring(start, end + 1)));
        }
        return result;
    }

    private List<String> moreleft(String s, int end, int start){
        List<String> result = new LinkedList<>();
        for(int i = end; i >= start; i--){
            if(s.charAt(i) == '(' && end - start > 0){
                if(i == start)
                    result.add(s.substring(i + 1, end + 1));
                else if(s.charAt(i - 1) != '(')
                    result.add(s.substring(start, i) + s.substring(i + 1, end + 1));
            }
        }
        return result;
    }

    private List<String> moreright(String s, int start, int end){
        List<String> result = new LinkedList<>();
        for(int i = start; i <= end; i++){
            if(s.charAt(i) == ')' && end - start > 0){
                if(i == end)
                    result.add(s.substring(start, i));
                else if(s.charAt(i + 1) != ')')
                    result.add(s.substring(start, i) + s.substring(i + 1, end + 1));
            }
        }
        return result;
    }

    private List<String> merge(int pos, List<List<String>> fragment){
        if(pos == fragment.size() - 1)
            return fragment.get(pos);
        List<String> now = fragment.get(pos);
        List<String> next = merge(pos + 1, fragment);
        List<String> result = new LinkedList<>();
        for(String s1 : now){
            for(String s2 : next){
                result.add(s1 + s2);
            }
        }
        if(next.size() == 0)
            return now;
        else if(now.size() == 0)
            return next;
        else
            return result;
    }

    public List<String> removeInvalidParentheses(String s) {
        int start = 0;
        int count = 0;
        List<List<String>> fragment = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')')
                count--;
            if(count < 0) {
                fragment.add(moreright(s, start, i));
                start = i + 1;
                count = 0;
            }
            else if(i == s.length() - 1 && count > 0)
                fragment.addAll(tailprocess(s, start));
            else if(i == s.length() - 1 && count == 0)
                fragment.add(Arrays.asList(s.substring(start, i + 1)));
        }
        if(fragment.size() == 0)
            return new LinkedList<>(Arrays.asList(s));
        List<String> result = merge(0, fragment);
        if (result.size() ==0)
            result.add("");
        return result;
    }

    public static void main(String[] args) {
        SolutionPlus solution = new SolutionPlus();
        System.out.println(solution.removeInvalidParentheses("(a(()()("));
    }

}
