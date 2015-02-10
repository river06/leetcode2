import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> ret = solver.findRepeatedDnaSequences(s);
		System.out.println(ret.size());
		for(String ss:ret) System.out.println(ss);
	}
}