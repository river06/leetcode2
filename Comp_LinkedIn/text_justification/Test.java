import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*String[] words = {"This", "is", "an", "example", "of", "text", "justification."};*/
		//String[] words = {"this"};
		//String[] words = {"a", "jjjjjjjjjjjjjjjj"};
		//String[] words = {"jjjjjjjjjjjjjjjj"};
		//String[] words = {"jjjjjjjjjjjjjjjj", "kkkk"};
		String[] words = {"jjjjjjjjjjjjjjjj", "kkkk", "JJJJJJJJJJJJJJ"};
		int n = 16;
		List<String> ret = solver.fullJustify(words, n);

		for (String str: ret) {
			System.out.println("|" + str +"|" );
		}
	}
}
