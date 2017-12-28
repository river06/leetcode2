import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] buildings = {
			{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
		};
		List<int[]> ret = solver.getSkyline(buildings);
		for (int[] interval: ret) {
			System.out.println(Arrays.toString(interval));
		}
	}
}
