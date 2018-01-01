import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] machines = {1, 0, 5};
		int[] machines = {0, 3, 0};

		int ret = solver.findMinMoves(machines);

		System.out.println(ret);
	}
}
