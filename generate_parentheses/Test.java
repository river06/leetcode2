import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
        int n = 3;
        List<String> ret = solver.generateParenthesis(n);
        for(String str:ret) System.out.println(str);

	}
}
