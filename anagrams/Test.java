import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] strs = {"", "", "", ""};
		List<String> ret = solver.anagrams( strs);
		for(int i=0; i<ret.size(); i++) {
			System.out.println(ret.get(i) );
		}
	}
}