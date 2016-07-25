import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
        List<Interval> intervals = new LinkedList<Interval>();
        
        /*intervals.add( new Interval(1,3));
        intervals.add( new Interval(6,9));
        
        Interval newInterval = new Interval(2,5);*/
        
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        
        Interval newInterval = new Interval(4,9);
        
        intervals = solver.insert(intervals, newInterval);
        
        for( Interval inter : intervals) {
            System.out.println( Integer.toString(inter.start) + "," + Integer.toString(inter.end));
        }
	}
}
