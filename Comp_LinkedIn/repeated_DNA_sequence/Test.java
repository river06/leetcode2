import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		String s = "AAAAAAAAAAAA";
		List<String> ret = solver.findRepeatedDnaSequences(s);

		System.out.println(ret);
	}
}
