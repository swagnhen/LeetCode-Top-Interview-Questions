package pers.swegnhan.leetcode.medium.sortingandsearching;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                int c1 = o1.start - o2.start;
                if(c1 == 0)
                    return o1.end - o2.end;
                return c1;
            }

        });
        for(int i = 0; i < intervals.size(); i++){
            int compare = intervals.get(i).end;
            for(int j = i + 1; j < intervals.size(); j++){
                if(compare >= intervals.get(j).start){
                    if(intervals.get(i).end < intervals.get(j).end) {
                        compare = intervals.get(j).end;
                        intervals.get(i).end = intervals.get(j).end;
                    }
                    intervals.remove(j--);
                }
            }
        }
        return intervals;
    }

    public static List<Interval> mergePlus(List<Interval> intervals){
        if(intervals.size() == 0)
            return intervals;
        intervals.sort(Comparator.comparing((Interval interval) -> interval.start)
                .thenComparing(interval -> interval.end));
        int pos = 0;
        int end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            if(end >= intervals.get(i).start){
                if(end < intervals.get(i).end){
                    end = intervals.get(i).end;
                    intervals.get(pos).end = end;
                }
                intervals.remove(i--);
            }
            else{
                pos = i;
                end = intervals.get(i).end;
            }
        }
        return intervals;
    }

    public static void main(String[] args){
        System.out.println(mergePlus(new ArrayList<>(Arrays.asList(
                new Interval(1,4),
                new Interval(0,2),
                new Interval(3,5),
                new Interval(15,18)
        ))));
    }

}
