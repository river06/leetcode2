import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		for (int n=0; n<100; n++) {
			int ret = solver.arrangeCoins(n);
			System.out.println(ret);
		}
	}
}
