package pers.swegnhan.leetcode.design;

import java.util.*;

public class InsertDeleteGetRandomO1 {

    int capacity = 256;

    int size = 0;

    int[] weight = new int[256];

    ArrayList<Integer>[] nums = new ArrayList[256];

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        for(int i = 0; i < nums.length; i++)
            nums[i] = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        int hashcode = Integer.hashCode(val) & (capacity - 1);
        if(nums[hashcode].contains(val))
            return false;
        nums[hashcode].add(val);
        weight[hashcode]++;
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int hashcode = Integer.hashCode(val) & (capacity - 1);
        if(!nums[hashcode].contains(val))
            return false;
        nums[hashcode].remove(nums[hashcode].indexOf(val));
        weight[hashcode]--;
        size--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int ran = Math.abs(random.nextInt() % size) + 1;
        int sum = 0, pos1 = -1, pos2 = 0;
        while(sum < ran){
            pos1++;
            sum += weight[pos1];
        }
        pos2 = ran - sum + weight[pos1] - 1;
        return nums[pos1].get(pos2);
    }

    public static void main(String[] args){
        InsertDeleteGetRandomO1 insertDeleteGetRandomO1 = new InsertDeleteGetRandomO1();
        insertDeleteGetRandomO1.insert(-1);
        insertDeleteGetRandomO1.remove(-2);
        insertDeleteGetRandomO1.insert(-2);
        System.out.println(insertDeleteGetRandomO1.getRandom());
        insertDeleteGetRandomO1.remove(-1);
        insertDeleteGetRandomO1.insert(-2);
        System.out.println(insertDeleteGetRandomO1.getRandom());
    }

}
