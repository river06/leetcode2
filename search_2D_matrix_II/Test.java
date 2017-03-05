import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] matrix = {
			{1,   4,  7, 11, 15},
			{2,   5,  8, 12, 19},
			{3,   6,  9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}
		};
		int target = 20;
		boolean ret = solver.searchMatrix( matrix, target );

		System.out.println( ret );
	}
}
