import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		
		//int[] test = {1,2};
		//int[] test = {3,4,2,3,1,2};
		int[] test = {1,4,2,3,3,4};
		
		
		Interval[] intervals = new Interval[test.length/2];
		for (int i=0; i<test.length; i+=2) {
			intervals[i/2] = new Interval(test[i], test[i+1]);
		}

		int[] ret = solver.findRightInterval(intervals);

		System.out.println( Arrays.toString(ret) );
	}
}
