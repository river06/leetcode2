import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int[][] matrix = {
			{1, 0, 1}, {0, -2, 3}
		};

		int k = 2;*/

		/*int[][] matrix = {
			{-1,-2}, {-1,-2}
		};
		int k = 0;*/

		/*int[][] matrix = { {2, 2, -1} };
		int k = 0;*/

		int[][] matrix = {
			{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}
		};
		int k = 8;

		int ret = solver.maxSumSubmatrix(matrix, k);

		System.out.println(ret);
	}
}
