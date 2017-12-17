import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int[][] grid ={
			{1, 0, 0, 1, 0},
			{0, 0, 1, 0, 1},
			{0, 0, 0, 1, 0},
			{1, 0, 1, 0, 1}};*/
		int[][] grid = {
			{1, 1, 1},
			{1, 1, 1},
			{1, 1, 1}};
		
		int ret = solver.countCornerRectangles(grid);
		System.out.println(ret);
	}
}
