import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[][] costs = {{1,2,3},{1,2,3}};
		int[][] costs = {{8},{9}};
		int ret = solver.minCostII(costs);

		System.out.println(ret);
	}
}
