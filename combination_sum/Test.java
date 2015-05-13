import java.util.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int target = 7;
		int[] candidates = {2,3,6,7};
		List<List<Integer>> ret = solver.combinationSum(candidates, target);
		for(List<Integer> com : ret) {
			System.out.println( com.toString() );
		}
	}
}
