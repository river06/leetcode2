import java.util.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int target = 8;
		int[] candidates = {10,1,2,7,6,1,5};
		List<List<Integer>> ret = solver.combinationSum2(candidates, target);
		for(List<Integer> com : ret) {
			System.out.println( com.toString() );
		}
	}
}
