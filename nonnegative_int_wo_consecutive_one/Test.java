import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		for (int i=0; i<=10; i++) {
			int ret = solver.findIntegers(i);
			System.out.println(i + ": " + ret);
		}
	}
}
