public class Relation {
	int[][] relation = {{1, 0}, {0, 1}};
	boolean knows(int a, int b) {
		if (relation[a][b] == 1) {
			return true;
		} else {
			return false;
		}
	}
}
