package pers.swegnhan.leetcode.hard.arrayandstrings;

import java.util.*;

public class FourSumII {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Set<String> set = new HashSet<>();
        Arrays.sort(A); Arrays.sort(B); Arrays.sort(C); Arrays.sort(D);
        return fourSumCountStep(0, B.length - 1, 0, D.length - 1, A, B, C, D, set);
    }

    public static int fourSumCountStep(int begina, int endb, int beginc, int endd, int[] A, int[] B, int[] C, int[] D, Set<String> set) {
        if(begina >= A.length || endb < 0 || beginc >= C.length || endd < 0)
            return 0;
        if(set.contains("" + begina + ' ' + endb + ' ' + beginc + ' ' + endd))
            return 0;
        set.add("" + begina + ' ' + endb + ' ' + beginc + ' ' + endd);
        if(A[begina] + B[endb] + C[beginc] + D[endd] == 0) {
            return 1 + fourSumCountStep(begina + 1, endb, beginc, endd, A, B, C, D, set)
                    + fourSumCountStep(begina, endb - 1, beginc, endd, A, B, C, D, set)
                    + fourSumCountStep(begina, endb, beginc + 1, endd, A, B, C, D, set)
                    + fourSumCountStep(begina, endb, beginc, endd - 1, A, B, C, D, set);
        }
        else if(A[begina] + B[endb] + C[beginc] + D[endd] > 0)
            return fourSumCountStep(begina, endb - 1, beginc, endd, A, B, C, D, set)
                    + fourSumCountStep(begina, endb, beginc, endd - 1, A, B, C, D, set);
        else
            return fourSumCountStep(begina + 1, endb, beginc, endd, A, B, C, D, set)
                + fourSumCountStep(begina, endb, beginc + 1, endd, A, B, C, D, set);
    }

    public static int fourSumCountPlus(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++)
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
        }
        int result = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++)
                result += map.getOrDefault((C[i] + D[j]) * -1, 0);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(fourSumCountPlus(new int[]{-1, -1},
                new int[]{-1, 1},
                new int[]{-1, 1},
                new int[]{1, -1}));
    }

}
