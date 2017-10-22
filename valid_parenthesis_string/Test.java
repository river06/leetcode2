import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] ss = {
			/*"",
			"(",
			"()",
			")(",
			"())",
			")",
			"()()",
			"(())",
			"*", "(*", "*)", "(*))", "((*)", "((*", "*))", "(*)",*/
			"(())((())()()(*)(*()(())())())()()((()())((()))(*"
			//"((*)(*))((*"
		};

		for (String s: ss) {
			System.out.println(s + ": " + solver.checkValidString(s));
		}
	}
}
