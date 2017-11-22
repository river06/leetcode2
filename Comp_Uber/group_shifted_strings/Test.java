import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] strings = {
			"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"
		};

		List<List<String>> ret = solver.groupStrings(strings);
		for (List<String> list: ret) {
			System.out.println(list);
		}
	}
}
