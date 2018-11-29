package pers.swegnhan.leetcode.easy.array;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        for(int i = 0, j = 0; i < nums.length; i++){
            if(nums[i] != 0){
                while(j < nums.length && nums[j] != 0)
                    j++;
                if(j == nums.length)
                    break;
                if(j < i) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] test = {1,0,2,0,5,0,7};
        moveZeroes(test);
        System.out.println("end");
    }

}
