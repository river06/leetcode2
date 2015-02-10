public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		String s1 = "abcdefghijklmnopq";
		String s2 = "efghijklmnopqcadb";

		boolean ret = solver.isScramble(s1,s2);

		System.out.println(ret);
	}
}
			