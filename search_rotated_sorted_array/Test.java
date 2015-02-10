public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		int[] A = {4,5,6,7,0,1,2};
		int target = 4;
		int ret = solver.search(A, target);
		System.out.println(ret);
	}
}