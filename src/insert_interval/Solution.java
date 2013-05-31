package insert_interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        Interval current = newInterval;
        int i = 0;
        for (; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (newInterval.start <= interval.start) {
                break;
            }
            else if (newInterval.start <= interval.end) {
                current = interval;
                current.end = Math.max(current.end, newInterval.end);
                break;
            }
            else
                result.add(interval);
        }

        for (; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
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