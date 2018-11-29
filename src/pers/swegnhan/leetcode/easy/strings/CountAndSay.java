package pers.swegnhan.leetcode.easy.strings;

public class CountAndSay {

    public static String countAndSay(int n) {
        if (n <=0 )
            return "";
        if (n == 1)
            return "1";
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i <= pre.length(); i++){
            if(i < pre.length() && pre.charAt(i) == pre.charAt(i - 1)){
                count++;
                continue;
            }
            else {
                sb.append(count);
                sb.append(pre.charAt(i - 1));
                count = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(countAndSay(5));
    }

}
