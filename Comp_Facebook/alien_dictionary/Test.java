import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] words = {
			"wrt",
			"wrf",
			"er",
			"ett",
			"rftt"
		};
		/*String[] words = {
			"z",
			"x",
			};*/

		String ret = solver.alienOrder(words);
		System.out.println(ret);
	}
}
