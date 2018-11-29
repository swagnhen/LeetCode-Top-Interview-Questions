package pers.swegnhan.leetcode.easy.others;

public class NumberOf1Bits {

    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(0xffffffff - 1);
    }

}
