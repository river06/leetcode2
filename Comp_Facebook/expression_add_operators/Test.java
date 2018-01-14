import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] nums = {"123", "232", "105", "00", "3456237490",
						 "1000000009"};
		int[] targets = {6, 8, 5, 0, 9191, 9};
		for (int i=0; i<nums.length; i++) {
			List<String> ret = solver.addOperators(nums[i], targets[i]);

			System.out.println("nums: " + nums[i] +
							   " target: " + targets[i]);
			System.out.println(ret);
		}
	}
}
