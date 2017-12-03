import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//char[][] grid = {{'1'}};
		/*String[] strs = {
			"11110",
			"11010",
			"11000",
			"00000"
		};*/
		/*String[] strs = {
			"11000",
			"11000",
			"00100",
			"00011"
		};*/
		String[] strs = {"1011011"};
		
		char[][] grid = new char[strs.length][strs[0].length()];
		for (int i=0; i<strs.length; i++) {
			grid[i] = strs[i].toCharArray();
		}
		int ret = solver.numIslands(grid);

		System.out.println(ret);
	}
}
