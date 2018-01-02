import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int[][] flights = {{0,1,1},{1,0,1},{1,1,0}};
		int[][] days = {{1,3,1},{6,0,3},{3,3,3}};*/
		/*int[][] flights = {{0,0,0},{0,0,0},{0,0,0}};
		int[][] days = {{1,1,1},{7,7,7},{7,7,7}};*/
		int[][] flights = {{0,1,1},{1,0,1},{1,1,0}};
		int[][] days = {{7,0,0},{0,7,0},{0,0,7}};

		int ret = solver.maxVacationDays(flights, days);

		System.out.println(ret);
	}
}
