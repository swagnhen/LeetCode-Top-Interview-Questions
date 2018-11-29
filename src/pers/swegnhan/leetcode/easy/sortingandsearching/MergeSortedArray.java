package pers.swegnhan.leetcode.easy.sortingandsearching;

import java.util.*;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        LinkedList<Integer> result = new LinkedList<>();
        while(p1 < m && p2 < n){
            if(nums1[p1] <= nums2[p2])
                result.add(nums1[p1++]);
            else
                result.add(nums2[p2++]);
        }
        while(p1 < m)
            result.add(nums1[p1++]);
        while(p2 < n)
            result.add(nums2[p2++]);
        for(int i = 0; i < m + n; i++)
            nums1[i] = result.remove();
    }

    public static void mergePlus(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n - 1, p3 = m + n -1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] >= nums2[p2])
                nums1[p3--] = nums1[p1--];
            else
                nums1[p3--] = nums2[p2--];
        }
        while(p1 >= 0)
            nums1[p3--] = nums1[p1--];
        while(p2 >= 0)
            nums1[p3--] = nums2[p2--];
    }

    public static void main(String[] args){
        int[] test1 = {0};
        int[] test2 = {1};
        mergePlus(test1,0,test2, 1);
        System.out.println("end");
    }

}
