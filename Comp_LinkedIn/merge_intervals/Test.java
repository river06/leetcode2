import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		List<Interval> ret = new ArrayList<Interval>();
		int[] nums = {1,4,0,4};

		for(int i=0; i<nums.length; i+=2 ) {
			ret.add( new Interval(nums[i],nums[i+1]) );
		}

		System.out.println("Original intervals:");

		for( Interval interval: ret ){
			System.out.println(
				interval.start
				+", "+ interval.end );
		}
		
		List<Interval> newRet = solver.merge( ret );

		System.out.println("result:");
		for( Interval interval: newRet ){
			System.out.println(
				interval.start
				+", "+ interval.end );
		}
		
	}
}
