package merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        ArrayList<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        Interval current = intervals.get(0);
        for (Interval interval : intervals) {
            if (interval.start <= current.end) {
                current.end = Math.max(current.end, interval.end);
            }
            else {
                result.add(current);
                current = interval;
            }
        }
        result.add(current);
        return result;
    }
}
