import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s = "abpcplea";
		String[] dd = {"ale", "apple", "monkey", "plea"};
		List<String> d = new LinkedList<String>();
		for (String lala: dd) {
			d.add(lala);
		}
		String ret = solver.findLongestWord(s, d);

		System.out.println(ret);
	}
}
