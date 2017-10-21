import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {1,1,2,1};

		List<List<Integer>> ret = solver.permuteUnique(nums);

		for (List<Integer> ans: ret) {
			System.out.println(ans);
		}
	}
}
