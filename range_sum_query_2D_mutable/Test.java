import java.util.*;
public class Test {
	public static void main(String[] args) {
		
		int[][] matrix = {
			{3, 0, 1, 4, 2},
			{5, 6, 3, 2, 1},
			{1, 2, 0, 1, 5},
			{4, 1, 0, 1, 7},
			{1, 0, 3, 0, 5}
		};

		NumMatrix solver = new NumMatrix(matrix);

		System.out.println(solver.sumRegion(2, 1, 4, 3)); // -> 8
		System.out.println(solver.sumRegion(1, 1, 2, 2));  //-> 11
		System.out.println(solver.sumRegion(1, 2, 2, 4)); // -> 12
	}
}
