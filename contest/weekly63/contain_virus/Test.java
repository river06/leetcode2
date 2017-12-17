import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] grid = {
			{0,1,0,0,0,0,0,1},
			{0,1,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0}
		};

		int ret = solver.containVirus(grid);

		System.out.println(ret);
	}
}
