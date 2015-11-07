import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String[] tokens = {"2", "1", "+", "3", "*"};
		String[] tokens = {"4", "13", "5", "/", "+"};
		int ret = solver.evalRPN(tokens);
		System.out.println(ret);
	}
}
