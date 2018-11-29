package pers.swegnhan.leetcode.easy.array;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        List<Integer> intersection = new LinkedList<Integer>();
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] < nums2[p2])
                p1++;
            else if(nums1[p1] > nums2[p2])
                p2++;
            else{
                intersection.add(nums1[p1]);
                p1++; p2++;
            }
        }
        int[] result = new int[intersection.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = intersection.get(i);
        return result;
    }

    public static void main(String[] args){
        int[] test = intersect(new int[]{1,2,2,1}, new int[] {2,2});
        System.out.println("end");
    }

}
