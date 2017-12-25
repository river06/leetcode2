import java.util.*;
public class Test {
	public static void main(String[] args) {
		
		String[] words = {"apple", "appear", "ati"};

		WordFilter wf = new WordFilter(words);

		//int ret = wf.f("a", "e");
		int ret = wf.f("a", "");
		//int ret = wf.f("b", "");

		System.out.println(ret);
	}
}
