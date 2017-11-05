public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		/*int[] A = {5,1,3};
		  int target = 3;*/
		int[] A = {5};
		int target = 3;
		int ret = solver.search(A, target);
		System.out.println(ret);
	}
}
