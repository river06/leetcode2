import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] ss = {"()())()", ")", ")(", ")()", "())", "()(",
					   "(((k()(("};
		for (String s: ss) {
			System.out.println("s is: " + s);
			
			List<String> ret = solver.removeInvalidParentheses(s);
			System.out.println(ret);
			System.out.println("****************");
		}
	}
}
