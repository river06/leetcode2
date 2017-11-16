import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] ns = {1, 37, 12, 32};
		for (int n: ns) {
			List<List<Integer>> ret = solver.getFactors(n);
			System.out.println("_________________________");
			System.out.println("n is " + n);
			for (List<Integer> list: ret) {
				System.out.println(list);
			}
		}
	}
}
