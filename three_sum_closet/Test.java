import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] num = {-1,2,1,-4};
		int target = 1;
		int ret = solver.threeSumClosest( num, target );
		
		System.out.println(ret);
	}
}