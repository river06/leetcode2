public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s ="aab";
		String p = "c*a*b";
		boolean ret = solver.isMatch(s,p);
		System.out.println(ret);
		
	}
}