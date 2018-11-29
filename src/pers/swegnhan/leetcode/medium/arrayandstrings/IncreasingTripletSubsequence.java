package pers.swegnhan.leetcode.medium.arrayandstrings;

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int pos = 0, low = Integer.MIN_VALUE, mid = Integer.MIN_VALUE, high = Integer.MIN_VALUE;
        while(pos < nums.length){
            if(pos + 1 < nums.length && nums[pos + 1] > nums[pos]){
                low = nums[pos];
                break;
            }
            pos++;
        }
        for(int i = pos; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[j] > nums[i]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] > nums[j])
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean increasingTripletPlus(int[] nums){
        int low = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= low)
                low = nums[i];
            else if(nums[i] <= mid)
                mid = nums[i];
            else
                return true;
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(increasingTripletPlus(new int[]{0,4,2,1,0,-1,-3}));
    }

}
