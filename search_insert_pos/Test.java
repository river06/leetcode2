public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] A = {1,3,5,6};
		int target = 7;
		int result = solver.searchInsert(A, target);
		System.out.println(result);
	}
}