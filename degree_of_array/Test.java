import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] numss = {
			{1, 2, 2, 3, 1},
			{1, 2, 2, 3, 1, 4, 2}
		};
		for (int[] nums: numss) {
			System.out.println(Arrays.toString(nums));
			int ret = solver.findShortestSubArray(nums);
			System.out.println(ret);
		}
	}
}
