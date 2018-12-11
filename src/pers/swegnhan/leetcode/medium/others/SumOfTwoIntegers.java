package pers.swegnhan.leetcode.medium.others;

public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        boolean carry = false;
        int result = 0, step = 0x00000001;
        for(int i = 0; i < 32; i++){
            if(carry == true){
                if((a & step) == step && (b & step) == step){
                    carry = true;
                    result = result | step;
                }
                else if((a & step) == step || (b & step) == step)
                    carry = true;
                else{
                    carry = false;
                    result = result | step;
                }
            }
            else{
                if((a & step) == step && (b & step) == step)
                    carry = true;
                else if((a & step) == step || (b & step) == step){
                    carry = false;
                    result = result | step;
                }
                else
                    carry = false;
            }
            step <<= 1;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(getSum(1,-2));
    }

}
