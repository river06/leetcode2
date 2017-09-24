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
    public int[] findRightInterval(Interval[] intervals) {
		// use a map
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i<intervals.length; i++) {
			map.put(intervals[i].start, i);
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		/*for(Interval tmp: intervals) {
			System.out.println( tmp.start + " | " + tmp.end);
		}*/
		
		int[] ret = new int[intervals.length];

		for (int i=0; i<intervals.length; i++) {
			int idx = binarySearch(intervals, i);

			if (idx < intervals.length &&
				intervals[idx].start >= intervals[i].end) {
				ret[map.get(intervals[i].start)] =
					map.get(intervals[idx].start);
			} else {
				ret[map.get(intervals[i].start)] = -1;
			}
		}

		return ret;
    }

	private int binarySearch(Interval[] intervals, int lIdx) {
		int end = intervals[lIdx].end;
		int l = lIdx+1;
		int r = intervals.length - 1;
		while (l < r) {
			int mid = l + (r-l)/2;
			if (intervals[mid].start < end) {
				l = mid+1;
			} else {
				r = mid;
			}
		}

		return l;
	}
}
