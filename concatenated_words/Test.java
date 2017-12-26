import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] words = {"cat","cats","catsdogcats","dog",
						  "dogcatsdog","hippopotamuses",
						  "rat","ratcatdogcat"};
		//String[] words = {"cat","dog","catdog"};
		List<String> ret = solver.findAllConcatenatedWordsInADict(words);

		System.out.println(ret);
	}
}
