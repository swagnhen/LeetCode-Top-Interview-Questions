package pers.swegnhan.leetcode.medium.sortingandsearching;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int pos = searchPos(nums);
        int rslt1 = -1, rslt2 = -1;
        if (pos > 0)
            rslt1 = binarySearch(nums, target, 0, pos - 1);
        rslt2 = binarySearch(nums, target, pos, nums.length - 1);
        if(rslt1 != -1)
            return rslt1;
        if(rslt2 != -1)
            return rslt2;
        return -1;
    }

    public static int searchPos(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1, preMid = 0;
        if(nums.length == 2 && nums[1] < nums[0])
            return 1;
        while(start < end){
            mid = (start + end + 1) / 2;
            if(preMid == mid)
                return mid;
            if(nums[mid] > nums[start])
                start = mid;
            else
                end = mid;
            preMid = mid;
        }
        return mid;
    }

    public static int binarySearch(int[] nums, int target, int start, int end){
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(nums[mid] < target)
                start = mid + 1;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(search(new int[]{3,5,1}, 1));
    }

}
