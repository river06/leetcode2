import java.util.*;

public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();

		int[] A = {1,1,2,2,2,3,3,3,3,3};
		
		int length = solver.removeDuplicates(A);

		System.out.println(length);
		System.out.println(Arrays.toString(A));
	}
}