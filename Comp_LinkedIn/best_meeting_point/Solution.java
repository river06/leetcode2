import java.util.*;
class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = getPos(grid, true);
		List<Integer> cols = getPos(grid, false);

		System.out.println(rows);
		System.out.println(cols);
		return getDistance(rows) + getDistance(cols);
    }

	private List<Integer> getPos(int[][] grid, boolean isRow) {
		List<Integer> ret = new LinkedList<Integer>();
		int n1 = isRow ? grid.length : grid[0].length;
		int n2 = isRow ? grid[0].length : grid.length;
		for (int i=0; i<n1; i++) {
			for (int j=0; j<n2; j++) {
				boolean isPeople = isRow ? grid[i][j] == 1 : grid[j][i] == 1;
				if (isPeople) {
					ret.add(i);
				}
			}
		}
		
		return ret;
	}

	private int getDistance(List<Integer> pos) {
		int l = 0;
		int r = pos.size() - 1;
		int dist = 0;
		while (l < r) {
			dist += pos.get(r) - pos.get(l);
			l++;
			r--;
		}
		return dist;
	}
}
