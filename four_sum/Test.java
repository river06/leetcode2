import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] num = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> ret = solver.fourSum( num , target);

		for(int i=0; i<ret.size(); i++) {
			List<Integer> line = ret.get(i);
			for(int j=0; j<line.size(); j++) {
				System.out.print( line.get(j) );
				System.out.print( "," );
			}
			System.out.println(" ");
		}
	}
}