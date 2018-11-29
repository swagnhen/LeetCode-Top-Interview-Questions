package pers.swegnhan.leetcode.easy.array;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            result[(i + k) % nums.length] = nums[i];
        for(int i = 0; i < nums.length; i++)
            nums[i] = result[i];
    }

    public static void main(String[] args){
        int[] test = {1, 2, 3, 4, 5};
        rotate(test, 3);
        System.out.println("end");
    }

}
