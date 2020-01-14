package pers.swegnhan.leetcode.hard.treesandgraphs;

import java.util.*;

public class CourseSchedule {

    public boolean isParent(int course1, int course2, List<Integer>[] parents){
        if(course1 == course2)
            return true;
        if(parents[course2].size() == 0)
            return false;
        for(int parent : parents[course2]){
            if(isParent(course1, parent, parents))
                return true;
        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] parents = new LinkedList[numCourses];
        for(int i = 0; i < parents.length; i++)
            parents[i] = new LinkedList<>();
        for(int i = 0; i < prerequisites.length; i++){
            if(isParent(prerequisites[i][0], prerequisites[i][1], parents)){
                return false;
            }
            parents[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] test = {
                {1,0},
                {0,1}
        };
        System.out.println(cs.canFinish(2, test));
    }

}
