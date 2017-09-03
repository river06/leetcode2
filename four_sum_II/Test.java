import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] A = {1, 2};
		int[] B = {-2, -1};
		int[] C = {-1, 2};
		int[] D = {0, 2};

		int ret = solver.fourSumCount(A, B, C, D);
		System.out.println(ret);

	}
}
