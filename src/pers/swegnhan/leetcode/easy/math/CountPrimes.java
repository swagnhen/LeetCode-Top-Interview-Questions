package pers.swegnhan.leetcode.easy.math;

import java.util.*;

public class CountPrimes {

    public static int countPrimes(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 2; i < n; i++) {
            int j = 0;
            Iterator<Integer> integers = result.iterator();
            while (integers.hasNext()) {
                if (i % integers.next() == 0)
                    break;
                j++;
            }
            if (j == result.size())
                result.add(i);
        }
        return result.size();
    }

    public static int countPrimesNoCollection(int n ) {
        int[] result = new int[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            int j = 0;
            while(j < count) {
                if (i % result[j] == 0)
                    break;
                j++;
            }
            if(j == count)
                result[count++] = i;
        }
        return count;
    }

    public static int countPrimesPlus(int n) {
        boolean[] isNotPrimes = new boolean[n];
        int count = 0;
        for(long i = 2; i < n; i++){
            if(isNotPrimes[(int)i] == false)
                count++;
            for(long j = i; i * j < n; j++)
                isNotPrimes[(int)(i * j)] = true;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(countPrimesNoCollection(499979));
    }
}
