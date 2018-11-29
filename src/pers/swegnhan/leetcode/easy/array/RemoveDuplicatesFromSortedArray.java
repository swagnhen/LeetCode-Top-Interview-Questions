package pers.swegnhan.leetcode.easy.array;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int length = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0) length++;
            if(i != 0 && nums[i] != nums[i - 1]){
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args){
        int[] test = {0,0,1,1,2,2};
        int length = removeDuplicates(test);
        System.out.println(length);
    }

}
