import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

		int ret = solver.countComponents(n, edges);

		System.out.println(ret);
	}
}
