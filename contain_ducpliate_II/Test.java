import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {1,1,3};

		boolean ret = solver.containsNearbyDuplicate( nums, 1);

		System.out.println( ret );
	}
}
