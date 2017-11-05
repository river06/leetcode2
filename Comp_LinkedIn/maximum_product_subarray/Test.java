import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] numss = {
			{0},
			{1},
			{-1},
			{0,1},
			{0,-1},
			{1,0},
			{-1,0},
			{1,-1},
			{-1,1},
			{0,1,2},
			{0,-1,-1},
			{0,-1,2},
			{0,1,-1},
			{2,-5,-2,-4,3}
		};
		

		for( int[] nums: numss ) {
			System.out.println( Arrays.toString( nums ) );
			System.out.println( solver.maxProduct(nums) );
			System.out.println( "-------------");
		}
			
	}
}
