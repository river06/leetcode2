public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		for(int n=1;n<=10;n++){
			String ret = solver.countAndSay(n);
			System.out.println(ret);
		}

	}
}
