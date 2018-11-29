package pers.swegnhan.leetcode.medium.dynamicprogramming;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        boolean[] canReach = new boolean[nums.length];
        canReach[nums.length - 1] = true;
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = 1; i + j < nums.length && j <= nums[i]; j++){
                if(canReach[i + j] == true){
                    canReach[i] = true;
                    break;
                }
            }
        }
        if(nums.length == 0)
            return true;
        return canReach[0];
    }

    public static boolean canJumpPlus(int[] nums){
        int last = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] >= last - i)
                last = last <= i? last : i;
        }
        if(last == 0)
            return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println(canJumpPlus(new int[]{2,3,1,1,4}));
    }

}
