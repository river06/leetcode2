import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {2,3,4,6,5,7,4,1,8,3};
		int c = 0;
		int r = 0;
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> row = new ArrayList<Integer>();
		for(int num: nums) {
			if( c > r) {
				r++;
				c=0;
				triangle.add( row );
			}

			if( c==0 ) {
				row = new ArrayList<Integer>();
			}

			row.add(num);
			c++;
		}
		triangle.add(row);

		for( List<Integer> tRow: triangle ) {
			System.out.println(tRow );
		}

		int ret = solver.minimumTotal( triangle );

		System.out.println("result is: " + ret );
				
	}
}
