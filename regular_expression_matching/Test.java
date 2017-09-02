public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s = "";
		String p = "a*b*c";

		boolean ret = solver.isMatch(s, p);
		System.out.println(ret);

	}
}