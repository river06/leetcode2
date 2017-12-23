import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] M = {
			{1,1,0},
			{1,1,0},
			{0,0,1}
		};

		int ret = solver.findCircleNum(M);

		System.out.println(ret);
	}
}
