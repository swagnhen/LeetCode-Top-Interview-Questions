package pers.swegnhan.leetcode.hard.treesandgraphs.CourseScheduleII;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] numParents = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            List<Integer> childrens = adjList.getOrDefault(prerequisites[i][1], new LinkedList<>());
            childrens.add(prerequisites[i][0]);
            numParents[prerequisites[i][0]]++;
            adjList.put(prerequisites[i][1], childrens);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numParents.length; i++){
            if(numParents[i] == 0)
                queue.add(i);
        }
        int pos = 0;
        int[] result = new int[numCourses];
        while(!queue.isEmpty()){
            int node = queue.remove();
            List<Integer> childrens = adjList.get(node);
            adjList.remove(node);
            result[pos++] = node;
            if(childrens != null) {
                for (int n : childrens) {
                    numParents[n]--;
                    if (numParents[n] == 0)
                        queue.add(n);
                }
            }
        }
        if(adjList.size() != 0)
            return new int[0];
        else
            return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {{1,0}},
        test2 = {{1,0},{2,0},{3,1},{3,2}},
        test3 = {{1,0},{1,2},{0,1}},
        test4 = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        System.out.println(Arrays.stream(solution.findOrder(2, test1)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(solution.findOrder(4, test2)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(solution.findOrder(3, test3)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(solution.findOrder(7, test4)).boxed().collect(Collectors.toList()));
    }

}
