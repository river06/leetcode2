import java.util.*;

public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();

		int[] A = {3,2,2,3};
		
		int length = solver.removeElement(A, 3);

		System.out.println(length);
		System.out.println(Arrays.toString(A));
	}
}