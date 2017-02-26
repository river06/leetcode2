import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {5,1,1};
		
		solver.nextPermutation(nums);
		
		System.out.println(Arrays.toString(nums));
	}
}
