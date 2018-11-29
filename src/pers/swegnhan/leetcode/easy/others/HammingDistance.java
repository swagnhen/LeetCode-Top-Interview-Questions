package pers.swegnhan.leetcode.easy.others;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int temp = x ^ y, count = 0;
        while(temp != 0){
            temp = (temp - 1) & temp;
            count++;
        }
        return count;
    }

}
