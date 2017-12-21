import java.util.*;
class Solution {
	private static final int WALL = -1;
	private static final int GATE = 0;
	private static final int EMPTY = Integer.MAX_VALUE;
	private static final int[][] DIR = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
			return;
		}
        Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		Queue<Integer> d = new LinkedList<Integer>();
		
		int m = rooms.length;
		int n = rooms[0].length;

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (rooms[i][j] == GATE) {
					xq.add(i);
					yq.add(j);
					d.add(0);
				}
			}
		}

		while (!xq.isEmpty()) {
			int x = xq.poll();
			int y = yq.poll();
			int dis = d.poll();
			for (int i=0; i<DIR.length; i++) {
				int nx = x + DIR[i][0];
				int ny = y + DIR[i][1];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n && rooms[nx][ny] == EMPTY) {
					rooms[nx][ny] = dis + 1;
					xq.add(nx);
					yq.add(ny);
					d.add(dis+1);
				}
			}
		}
    }
}
