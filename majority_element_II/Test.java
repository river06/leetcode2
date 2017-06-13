import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] testCases = {
			{1},
			{0},
			{1,0},
			{1,0,0},
			{0,0,1},
			{8,8,7,7,7},
			{1,2,2,3,2,1,1,3}
		};

		for (int[] nums: testCases) {
			System.out.println( "Test case: " + Arrays.toString(nums) );
			System.out.println(solver.majorityElement(nums));
		}
	}
}
