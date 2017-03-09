import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] num = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		
		List<List<Integer>> ret = solver.threeSum( num );
		
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
