import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		//int[][] matrix = {{1,2},{3,4}};
		solver.rotate( matrix );
		for( int i=0; i<matrix.length; i++ ) {
			System.out.println( Arrays.toString( matrix[i] ) );
		}
	}
}
