import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {0, 1, 0, 3, 12};
		solver.moveZeroes(nums);

		System.out.println(Arrays.toString(nums));
	}
}
