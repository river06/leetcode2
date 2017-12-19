import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int n = Integer.MIN_VALUE + 2;
		//int n = 3;
		//int n = Integer.MAX_VALUE;
		int ret = solver.hammingWeight(n);
		System.out.println(ret);
	}
}
