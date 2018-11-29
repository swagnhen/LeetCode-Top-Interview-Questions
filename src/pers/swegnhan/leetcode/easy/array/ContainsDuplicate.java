package pers.swegnhan.leetcode.easy.array;

public class ContainsDuplicate {

    static class MyDictionary{

        private int count = 0;

        private int size = 1;

        private int[] nums = new int[size];

        public void add(int num){
            if(count == size){
                size *= 2;
                int[] temp = new int[size];
                for(int i = 0; i < nums.length; i++)
                    temp[i] = nums[i];
                nums = temp;
            }
            nums[count++] = num;
        }

        public boolean contain(int num){
            for(int i = 0; i < count; i++)
                if(nums[i] == num)
                    return true;
            return false;
        }
        
    }

    public static boolean containsDuplicate(int[] nums) {
        MyDictionary dictionary = new MyDictionary();
        for(int i = 0; i < nums.length; i++){
            if(dictionary.contain(nums[i]))
                return true;
            dictionary.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }

}
