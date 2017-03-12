import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] numArrays = {{},{1},{2,1,5,6,2,3}};

		for( int[] numArray: numArrays ) {
			int ret = solver.largestRectangleArea( numArray );
			System.out.println( Arrays.toString( numArray ));
			System.out.println(ret);
			System.out.println("---------------");
		}
	}
}
