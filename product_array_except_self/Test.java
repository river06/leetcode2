import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {1,2,3,4};

		int[] ret = solver.productExceptSelf(nums);

		System.out.println( Arrays.toString(ret) );
	}
}
