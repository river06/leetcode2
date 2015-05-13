import java.util.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int n = 4;
		int k = 2;
		List<List<Integer>> ret = solver.combine(n, k);

		for(List<Integer> cur : ret) {
			System.out.println( cur.toString() );
		}
	}
}
