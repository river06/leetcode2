import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int m = 3;
		int n = 3;
		//int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};
		//int[][] positions = {{0,1},{1,2},{2,1},{1,0},{0,2},{0,0},{1,1}};
		int[][] positions = {{0,1},{1,2},{2,1},{1,0},{0,2},{1,1}};
		List<Integer> ret = solver.numIslands2(m, n, positions);

		System.out.println(ret);
	}
}
