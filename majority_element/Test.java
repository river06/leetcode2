import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] testCases = {
			{1},
			{1,1,2},
			{1,2,2},
			{1,2,1},
			{1,1,1},
			{1,2,3,4,4,4}
		};

		for (int[] testCase: testCases) {
			System.out.println( Arrays.toString(testCase) );
			System.out.println( solver.majorityElement( testCase ) );
		}
	}
}
