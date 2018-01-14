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
    public int minMeetingRooms(Interval[] intervals) {
        // sort intervals
		Arrays.sort(intervals, new IntervalComparator());

		List<Interval> li = new ArrayList<Interval>();
		for (Interval interval: intervals) {
			boolean isAdded = false;
			for (int i=0; i<li.size(); i++) {
				if (li.get(i).end <= interval.start) {
					li.get(i).end = interval.end;
					isAdded = true;
					break;
				}
			}
			if (!isAdded) {
				li.add(interval);
			}
		}
    }
	class IntervalComparator implements Comparator<Interval> {
		public int compare (Interval a, Interval b) {
			if (a.start != b.start) {
				return a.start - b.start;
			} else {
				return b.end - a.end;
			}
		}
	}
}
