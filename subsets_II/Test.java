import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] S = {1,2,2};
		ArrayList<ArrayList<Integer>> ret = solver.subsetsWithDup(S);
		for(int i=0; i<ret.size(); i++) {
			System.out.println(ret.get(i));
		}
		
	}
}