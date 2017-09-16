import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {2,3,1,2,4,3};
		int s = 7;

		System.out.println( solver.minSubArrayLen(s, nums));
	}
}
