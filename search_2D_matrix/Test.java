public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		//int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		int[][] matrix = {{1}};
		int target = 0;
		boolean ret = solver.searchMatrix(matrix, target);
		System.out.println(ret);
	}
}
