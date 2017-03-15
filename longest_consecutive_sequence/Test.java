import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {100, 4, 200, 1, 3, 2};
		int ret = solver.longestConsecutive( nums );

		System.out.println( Arrays.toString( nums ) );
		System.out.println( ret );
	}
}
