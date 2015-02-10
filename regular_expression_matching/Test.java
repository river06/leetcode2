public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s = "a";
		String p = ".*..a*";

		boolean ret = solver.isMatch(s, p);
		System.out.println(ret);

	}
}