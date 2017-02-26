import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums= {3,1};
		int target = 1;
		boolean ret = solver.search(nums, target);
		
		System.out.println(ret);
	}
}
