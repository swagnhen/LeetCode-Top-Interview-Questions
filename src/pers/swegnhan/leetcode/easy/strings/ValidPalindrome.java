package pers.swegnhan.leetcode.easy.strings;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        String test = s.toLowerCase();
        int low = 0, high = test.length() - 1;
        while (low < high && high < test.length()){
            while(low < test.length() && !Character.isLetterOrDigit(test.charAt(low)))
                low++;
            while(high >= 0 && !Character.isLetterOrDigit(test.charAt(high)))
                high--;
            if(low < test.length() && high >= 0 && test.charAt(low) != test.charAt(high))
                return false;
            low++; high--;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome("0P"));
    }

}
