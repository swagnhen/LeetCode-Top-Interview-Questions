package pers.swegnhan.leetcode.medium.sortingandsearching;

public class SearchForARange {

    public static int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] > target)
                high = mid - 1;
            else if (nums[mid] < target)
                low = mid + 1;
            else {
                low = high = mid;
                while (low >= 0 && nums[low] == target)
                    low--;
                while (high < nums.length && nums[high] == target)
                    high++;
                return new int[]{low + 1, high - 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] searchRangePlus(int[] nums, int target) {
        int low = 0, mid = 0, high = nums.length - 1;
        int[] result = {-1, -1};
        while(low < high){
            mid = (low + high) / 2;
            if(nums[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        if(nums.length == 0 || nums[low] != target)
            return result;
        result[0] = low;
        high = nums.length - 1;
        while(low < high){
            mid = (low + high + 1) / 2;
            if(nums[mid] <= target)
                low = mid;
            else
                high = mid - 1;
        }
        result[1] = high;
        return result;
    }

    public static void main(String[] args){
        int[] test = searchRangePlus(new int[]{2,2,2,2,2}, 2);
        System.out.println("end");
    }

}
