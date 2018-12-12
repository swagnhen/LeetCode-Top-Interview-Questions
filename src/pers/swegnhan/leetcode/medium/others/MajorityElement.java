package pers.swegnhan.leetcode.medium.others;

import java.util.*;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, maxkey = 0;
        for(int input : nums){
            if(!map.containsKey(input))
                map.put(input, 0);
            map.put(input, map.get(input) + 1);
            if(map.get(input) > max) {
                max = map.get(input);
                maxkey = input;
            }
        }
        return maxkey;
    }

    public static int majorityElementPlus(int[] nums) {
        int count = 0, key = 0;
        for(int input : nums){
            if(count == 0){
                count++;
                key = input;
            }
            else if(key == input)
                count++;
            else
                count--;
        }
        return key;
    }

    public static void main(String[] args){
        System.out.println(majorityElementPlus(new int[]{1,2,3,3,3,3,3,3}));
    }

}
