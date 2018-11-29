package pers.swegnhan.leetcode.medium.sortingandsearching;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        for(int i = 1; i < nums.length - 1; i ++)
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        if(nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;
        return -1;
    }

    public static int findPeakElementPlus(int[] nums) {
        return findPeakElementPlusStep(nums, 0, nums.length - 1);
    }

    public static int findPeakElementPlusStep(int[] nums, int start , int end) {
        if(start == end)
            return start;
        int mid = (start + end) / 2;
        if(nums[mid] > nums[mid + 1])
            return findPeakElementPlusStep(nums, start, mid);
        else
            return findPeakElementPlusStep(nums, mid + 1, end);
    }

    public static void main(String[] args){
        System.out.println(findPeakElementPlus(new int[]{1, 2, 3, 1}));
    }

}
