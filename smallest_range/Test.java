import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		nums.add(Arrays.asList(4,10,15,24,26));
		nums.add(Arrays.asList(0,9,12,20));
		nums.add(Arrays.asList(5,18,22,30));

		int[] ret = solver.smallestRange(nums);
		System.out.println(Arrays.toString(ret));
	}
}
