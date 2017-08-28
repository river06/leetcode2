import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		int[][] testNums = {
			{1},
			{1,2},
			{1,2},
			{1,2,3},
			{1,2,3},
			{1,2,3,4,5,6}
		};

		int[] testK = {0,1,2,1,4,2};

		for(int i=testNums.length-1; i<testNums.length; i++) {
			int[] nums = testNums[i];
			System.out.println( "nums: " + Arrays.toString( nums ) );
			System.out.println( "k: " + testK[i] );
			solver.rotate(nums, testK[i]);
			System.out.println( "ret: " + Arrays.toString( nums ) );
			
		}
	}
}
