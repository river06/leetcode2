import java.util.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int k = 3;
		int n = 9;
		List<List<Integer>> ret = solver.combinationSum3(k,n);
		for(List<Integer> com : ret) {
			System.out.println( com.toString() );
		}
	}
}
