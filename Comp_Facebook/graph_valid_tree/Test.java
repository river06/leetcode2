import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int n = 5;
		//int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		boolean ret = solver.validTree(n, edges);

		System.out.println(ret);
	}
}
