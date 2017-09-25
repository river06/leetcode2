import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int m = 3;
		int n = 3;
		int k = 5;*/
		int m = 2;
		int n = 3;
		int k = 6;
		

		int ret = solver.findKthNumber(m, n, k);

		System.out.println(ret);
	}
}
