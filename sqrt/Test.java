import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		for( int x=0; x <100; x++) {
			int ret = solver.mySqrt(x);
			System.out.println(x + ": " + ret);
		}
	}
}
