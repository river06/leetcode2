import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		for (int n=1; n<=5; n++) {
			List<List<Integer>> map = solver.consistentHashing(n);

			System.out.println("------- n = " + n +" -------");
			for (List<Integer> sector: map) {
				System.out.println(sector);
			}
			System.out.println("--------------");
		}
				
	}
}
