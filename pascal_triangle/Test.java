import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] numRows = {1,2,3,4,5};
		for( int num: numRows ) {
			List<List<Integer>> ret = solver.generate( num );
			for( List<Integer> cur : ret ) {
				System.out.println( cur );
			}
			System.out.println("----------");
		}

	}
}
