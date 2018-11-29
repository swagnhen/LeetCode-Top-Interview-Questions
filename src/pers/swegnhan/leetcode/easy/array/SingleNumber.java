package pers.swegnhan.leetcode.easy.array;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;
        if(nums.length != 0)
            result = nums[0];
        for(int i = 1; i < nums.length; i++)
            result ^= nums[i];
        return result;
    }

    public static void main(String[] args){
        System.out.println(singleNumber(new int[] {2,2,1}));
    }

}
