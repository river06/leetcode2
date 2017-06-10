import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] heightMap1 = {
			{1,4,3,1,3,2},
			{3,2,1,3,2,4},
			{2,3,3,2,3,1}
		};

		int[][] heightMap2 = {
			{12,13,1,12},
			{13,4,13,12},
			{13,8,10,12},
			{12,13,12,12},
			{13,13,13,13}
		};

		int[][] heightMap = heightMap2;

		int ret = solver.trapRainWater(heightMap);

		System.out.println( ret );
	}
}
