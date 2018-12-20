package pers.swegnhan.leetcode.hard.arrayandstrings;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int max = 0, start = 0, end = height.length - 1;
        while(start < end){
            int area = (end - start) * Math.min(height[start], height[end]);
            max = max >= area ? max : area;
            if(height[start] < height[end])
                start++;
            else
                end--;
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

}
