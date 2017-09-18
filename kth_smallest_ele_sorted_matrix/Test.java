import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] matrix = {
			{1, 5, 9}, {10, 11, 13}, {12, 13, 15}
		};


		for (int k=1; k<=matrix.length*matrix.length; k++) {
			int ret = solver.kthSmallest(matrix, k);
			System.out.println(k + ": " + ret);
		}
	}
}
