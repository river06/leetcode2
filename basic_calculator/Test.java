import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] testCases = {
			"1 + 1",
			" 2-1 + 2",
			"(1+(4+5+2)-3)+(6+8)",
			" ",
			"(((((1+3)))))",
			"(1)-((2+3)-5+6-((3+2)-(4-2)+((2-2))))",
			"2147483647"
		};

		for (String testCase: testCases) {
			int ret = solver.calculate(testCase);
			System.out.println(testCase + ": " + ret);
		}
	}
}
