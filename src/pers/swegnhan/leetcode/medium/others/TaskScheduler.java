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

    public static int leastIntervalPlus(char[] tasks, int n) {
        int[] map = new int[26];
        for(char input : tasks)
            map[input - 'A']++;
        Arrays.sort(map);
        int countMax = 0;
        for(int count : map){
            if(count == map[25])
                countMax++;
        }
        int posibility = (map[25] - 1) * (n + 1) + countMax;
        return tasks.length >= posibility ? tasks.length : posibility;
    }

    public static void main(String[] args){
        System.out.println(leastIntervalPlus(new char[]{'A','A','A','B','B','B'}, 50));
    }

}
