import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] ret = solver.generateMatrix( 1 );

		for( int i=0; i< ret.length; i++ ) {
			System.out.println( Arrays.toString( ret[i] ) );
		}
	}
}
