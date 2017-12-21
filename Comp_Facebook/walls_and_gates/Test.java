import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int EMPTY = Integer.MAX_VALUE;
		int[][] rooms = {
			{EMPTY, -1, 0, EMPTY},
			{EMPTY, EMPTY, EMPTY, -1},
			{EMPTY, -1, EMPTY, -1},
			{0, -1, EMPTY, EMPTY}
		};

		solver.wallsAndGates(rooms);
		for (int[] line: rooms) {
			System.out.println(Arrays.toString(line));
		}
	}
}
