import java.util.*;
public class Test {
	public static void main(String[] args) {

			
		String[] sentences = {
			"i love you", "island","ironman", "i love leetcode"
		};
		int[] times = {5, 3, 2, 2};
		AutocompleteSystem sys = new AutocompleteSystem(sentences, times);
		List<String> ret = sys.input('i');
		System.out.println(ret);

		ret = sys.input(' ');
		System.out.println(ret);
	}
}
