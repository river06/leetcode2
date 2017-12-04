import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s = "aab";
		List<List<String>> ret = solver.partition(s);
		for (List<String> row: ret) {
			System.out.println(row);
		}
	}
}
