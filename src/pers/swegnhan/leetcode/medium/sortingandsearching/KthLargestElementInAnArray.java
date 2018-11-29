package pers.swegnhan.leetcode.medium.sortingandsearching;

public class KthLargestElementInAnArray {

    public static int quickSort(int[] nums, int start, int end, int k){
        int mid = partition(nums, start, end);
        if(mid > k)
            return quickSort(nums, start, mid - 1, k);
        else if (mid < k)
            return quickSort(nums, mid + 1, end, k);
        else
            return nums[mid];
    }

    public static int partition(int[] nums, int start, int end){
        int low = start, high = start;
        while(high < end){
            if(nums[high] < nums[end]){
                int swap = nums[low];
                nums[low] = nums[high];
                nums[high] = swap;
                low++;
            }
            high++;
        }
        int swap = nums[low];
        nums[low] = nums[end];
        nums[end] = swap;
        return low;
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public static void main(String[] args){
        int[] test = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(test, 2));
    }

}
