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
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if( intervals.size()<=1 ) { return intervals; }

		// sort
		Collections.sort(intervals, new IntervalComparator() );
		// initialize values
		Interval cur = intervals.get(0);
		
		int idx = 1; // index of next interval in list

		while( idx < intervals.size() ) {
			Interval next = intervals.get(idx);
			// merge
			if( next.start<= cur.end ) {
				cur.end = Math.max( cur.end, next.end);
				intervals.remove(idx);
			} else {
				cur = next;
				idx++;
			}
		}

		return intervals;
    }

	private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}
}
