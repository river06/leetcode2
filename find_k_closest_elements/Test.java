import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		/*int[] arr = {1,2,3,4,5};
		int k = 4;
		int x = 3;*/
		
		int[] arr = {1,2,3,4,5};
		int k = 4;
		int x = 4;
		List<Integer> ret = solver.findClosestElements(arr, k, x);

		System.out.println(ret);
	}
}
