import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] S = {4,4,4,1,4};
		List<List<Integer>> ret = solver.subsetsWithDup(S);
		for(int i=0; i<ret.size(); i++) {
			System.out.println(ret.get(i));
		}
		
	}
}
