public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		int ret = solver.calculateMinimumHP(dungeon);
		System.out.println(ret);
	}
}