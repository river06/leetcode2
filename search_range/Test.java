import java.util.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] A = {5,7,7,8,8,10};
		int target = 8;
		int[] ret = solver.searchRange(A, target);
		System.out.println(Arrays.toString(ret));
	}
}