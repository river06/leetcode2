public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = solver.trap(A);
		System.out.println(result);
	}
}