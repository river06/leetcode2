import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		String[] testCases = {
			"3+2*2",
			" 3/2 ",
			" 3+5 / 2 ",
			"12",
			"1-2",
			"-1"
		};

		for (String testCase : testCases) {
			int ret = solver.calculate(testCase);
			System.out.println(testCase + ": " + ret);
		}

	}
}
