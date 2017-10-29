/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) { return intervals; }
		int idx = 0;
		while (idx < intervals.size()) {
			if (newInterval.start <= intervals.get(idx).end) {
				break;
			}
			idx++;
		}


		while (idx < intervals.size() ) {
			Interval tmp = intervals.get(idx);
			if (newInterval.end < tmp.start) {
				break;
			} else {
				newInterval.start = Math.min(newInterval.start, tmp.start);
				newInterval.end = Math.max(newInterval.end, tmp.end);
				intervals.remove(idx);
			}
		}
		intervals.add(idx, newInterval);

		return intervals;
    }
}
