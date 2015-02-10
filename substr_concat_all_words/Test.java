import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		ArrayList<Integer> ret = solver.findSubstring(S, L);
		for(int i=0; i<ret.size(); i++) {
			System.out.println( ret.get(i) );
		}
	}
}