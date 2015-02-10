import java.util.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] num = {3,1,3};
		ArrayList<ArrayList<Integer>> result = solver.permuteUnique(num);

		for(int i=0; i<result.size(); i++) {
			ArrayList<Integer> tmp = result.get(i);
			String tmp_s = tmp.toString();
			System.out.println(tmp_s);
		}
	}
}