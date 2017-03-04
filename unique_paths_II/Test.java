import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] obstacleGrid = {
			{0,0,0},
			{0,1,0},
			{0,0,0}
		};

		int ret = solver.uniquePathsWithObstacles(obstacleGrid);

		System.out.println( ret );
	}
}
