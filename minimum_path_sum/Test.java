import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] grid = {{1,2},{4,2}};

		int ret = solver.minPathSum( grid );

		System.out.println( ret );

	}
}
