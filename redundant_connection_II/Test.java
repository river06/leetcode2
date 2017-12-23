import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
//		int[][] edges = {{1,2},{1,3},{2,3}};
		//int[][] edges = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
		//int[][] edges = {{4,2},{1,5},{5,2},{5,3},{2,4}};
		//int[][] edges = {{2,1},{3,1},{4,2},{1,4}};
		//int[][] edges = {{4,1},{1,2},{1,3},{4,5},{5,6},{6,5}};
		//int[][] edges = {{2,3}, {3,4}, {4,1}, {1,5}, {1,2}};
		//int[][] edges = {{3,1},{1,4},{3,5},{1,2},{1,5}};
		int[][] edges = {{1,2},{2,3},{3,1}};

		int[] ret = solver.findRedundantDirectedConnection(edges);

		System.out.println(Arrays.toString(ret));
	}
}
