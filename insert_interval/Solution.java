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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n_inverval = intervals.size();
        /*if(n_inverval<=0) {
            intervals.add( newInterval);
            return intervals;
        }*/
        
        for(int i=0; i<n_inverval; i++) {
            if( newInterval.start <= intervals.get(i).end) {
                
                if( newInterval.start < intervals.get(i).start) {
                    intervals.add(i,newInterval);
                    n_inverval ++;
                } else {
                    intervals.get(i).end = Math.max( newInterval.end, intervals.get(i).end);
                }
                
                int newIntervalEnd = intervals.get(i).end;
                while( i+1 < n_inverval) {
                    if( newIntervalEnd < intervals.get(i+1).start) {
                        break;
                    } else if ( newIntervalEnd >= intervals.get(i+1).start &&
                               newIntervalEnd <= intervals.get(i+1).end) {
                        intervals.get(i).end = intervals.get(i+1).end;
                        intervals.remove(i+1);
                        break;
                    } else { // newInterval.end > intervals.get(j).end
                        intervals.remove(i+1);
                        n_inverval --;
                    }
                }
                return intervals;
            }
        }
        
        intervals.add(newInterval);
        return intervals;
    }
}