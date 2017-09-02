public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] testCases = {
			"010",
			"000",
			"2147483647",
			"-2147483648",
			"2147483648",
			"-2147483649",
			"-2147483647",
			" 1",
			" -1",
			" 1cc",
			"lalala",
			" lalala",
			" -lalala",
			"123  456"
		};
		for (String testCase: testCases) {
			System.out.println(testCase + ": " + solver.myAtoi(testCase));
		}
		
	}
}