import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[][] edges = {{1,2}, {1,3}, {2,3}};
		int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
		int[] ret = solver.findRedundantConnection(edges);

		System.out.println(Arrays.toString(ret));
	}
}
