import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int maxInteger = 10;
		int total = 40;
		boolean ret = solver.canIWin(maxInteger, total);

		System.out.println(ret);
	}
}
