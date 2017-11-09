import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] A = {
			{1, 0, 0},
			{-1, 0, 3}
		};

		int[][] B = {
			{7, 0, 0},
			{0, 0, 0},
			{0, 0, 1}
		};

		int[][] C = solver.multiply(A, B);

		for (int[] row: C) {
			System.out.println(Arrays.toString(row));
		}
	}
}
