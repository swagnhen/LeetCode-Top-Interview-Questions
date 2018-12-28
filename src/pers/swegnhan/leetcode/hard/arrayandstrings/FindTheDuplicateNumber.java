package pers.swegnhan.leetcode.hard.arrayandstrings;

public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int[] bucket = new int[nums.length];
        for(int num : nums)
            bucket[num]++;
        for(int i = 0; i < nums.length; i++) {
            if (bucket[i] >= 2)
                return i;
        }
        return -1;
    }

    public static int findDuplicatePlus(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args){
        System.out.println(findDuplicatePlus(new int[]{1,3,4,2,2}));
    }

}
