import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		for (int num=0; num<=100; num++) {
			boolean ret = solver.isPerfectSquare(num);

			System.out.println(num + ": " + ret);
		}
	}
}
