import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int n = 10;
		int[][] prerequisites
			={{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		int[] ret = solver.findOrder(n, prerequisites);
		System.out.println(Arrays.toString(ret));
	}
}
