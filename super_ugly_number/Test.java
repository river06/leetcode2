import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] primes = {2, 7, 13, 19};

		for (int i=1; i<=12; i++) {
			System.out.println(solver.nthSuperUglyNumber(i, primes));
		}
	}
}
