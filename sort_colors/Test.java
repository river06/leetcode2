import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] nums = {{0},{1},{2},{0,1},{1,2},{0,2},{1,0},{2,1},{2,0},{2,1,0},{0,1,2},
					  {0,0,2,2,1,1,0}};
		for( int i=0; i<nums.length; i++ ) {
			solver.sortColors( nums[i] );
			System.out.println( Arrays.toString( nums[i] ) );
		}
	}
}
