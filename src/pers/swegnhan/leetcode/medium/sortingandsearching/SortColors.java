package pers.swegnhan.leetcode.medium.sortingandsearching;

public class SortColors {

    public static void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++){
            switch (nums[i]){
                case 0:
                    num0++;
                    break;
                case 1:
                    num1++;
                    break;
                case 2:
                    num2++;
                    break;
            }
        }
        for(int i = 0; i < num0; i++)
            nums[i] = 0;
        for(int i = num0; i < num0 + num1; i++)
            nums[i] = 1;
        for(int i = num0 + num1; i < nums.length; i ++)
            nums[i] = 2;
    }

    public static void main(String[] args){

    }

}
