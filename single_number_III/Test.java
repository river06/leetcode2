import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {1,2,1,3,2,5};
		int[] ret = solver.singleNumber( nums );
		System.out.println( Arrays.toString( ret ) );
	}
}
