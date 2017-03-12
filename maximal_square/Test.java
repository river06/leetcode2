import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] matrixInt = {
			{0, 1, 1, 1},
			{0, 1, 1, 1},
			{0, 1, 1, 1},
			{1, 1, 0, 0},
		};
		char[][] matrix = new char[matrixInt.length][matrixInt[0].length];
		for( int i=0; i<matrixInt.length; i++) {
			for(int j=0; j<matrixInt[0].length; j++ ) {
				matrix[i][j] = (char) ([i][j]+'0');
			}
		}

		int ret = solver.maximalSquare( matrix );

		System.out.println( ret );
	}
}
