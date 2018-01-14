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
        Integer[] starts = new Integer[intervals.length];
		Integer[] ends = new Integer[intervals.length];
		for (int i=0; i<intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		
		Arrays.sort(starts);
		Arrays.sort(ends);

		int s = 0;
		int e = 0;
		int nRoom = 0;
		int maxRoom = 0;
		while (s < intervals.length) {
			if (starts[s] < ends[e]) {
				nRoom++;
				maxRoom = Math.max(maxRoom, nRoom);
				s++;
			} else {
				nRoom--;
				e++;
			}
		}

		return maxRoom;
    }
}
