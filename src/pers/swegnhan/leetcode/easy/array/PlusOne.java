package pers.swegnhan.leetcode.easy.array;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        while(p >= 0){
            if(digits[p] != 9){
                digits[p] += 1;
                return digits;
            }
            else{
                digits[p] = 0;
                p--;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for(int i = 1; i < result.length; i++)
            result[i] = digits[i - 1];
        return result;
    }

    public static void main(String[] args){
        int[] test = plusOne(new int[]{9,9,8});
        System.out.println("end");
    }

}
