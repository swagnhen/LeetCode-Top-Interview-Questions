package pers.swegnhan.leetcode.medium.others;

import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        boolean[] isDone = new boolean[tasks.length];
        int[] map = new int[26];
        int count  = 0, areadyDone = 0;
        boolean hasDone = false;
        while(areadyDone < tasks.length) {
            hasDone = false;
            for (int i = 0; i < tasks.length; i++) {
                if (isDone[i] == false && map[tasks[i] - 'A'] == 0) {
                    hasDone = true;
                    isDone[i] = true;
                    count++;
                    areadyDone++;
                    map[tasks[i] - 'A'] = n + 1;
                    for(int j = 0; j < map.length; j++){
                        if(map[j] != 0)
                            map[j]--;
                    }
                }
            }
            if(hasDone == false){
                for(int j = 0; j < map.length; j++){
                    if(map[j] != 0)
                        map[j]--;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

}
