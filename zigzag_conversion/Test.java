public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s = "PAYPALISHIRING";
		int nRows = 3;

		String ret = solver.convert(s, nRows);

		System.out.println(ret);
	}
}