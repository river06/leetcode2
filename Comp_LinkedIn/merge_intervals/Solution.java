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
	class intervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	}
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new LinkedList<Interval>();
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		Collections.sort(intervals, new intervalComparator());
		Interval lastInterval = intervals.get(0);
		for (Interval newInterval: intervals) {
			if (ret.size() == 0) {
				ret.add(newInterval);
				lastInterval = newInterval;
			} else {
				if (lastInterval.end < newInterval.start) {
					ret.add(newInterval);
					lastInterval = newInterval;
				} else {
					lastInterval.end = Math.max(lastInterval.end,
												newInterval.end);
				}
			}
		}
		return ret;
    }
}
