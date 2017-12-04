import java.util.*;
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
		// some special cases
		List<Integer> ret = new ArrayList<Integer>();
		if (positions == null) { return ret; }

		boolean[][] isLand = new boolean[m][n];
		
		UnionFind uf = new UnionFind(m, n);

		int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		for (int[] pos: positions) {
			if (!isLand[pos[0]][pos[1]]) {
				isLand[pos[0]][pos[1]] = true;
				uf.makeSet(pos[0], pos[1]);
				for (int[] dx: delta) {
					int x = pos[0] + dx[0];
					int y = pos[1] + dx[1];
					if (x >= 0 && x < m && y >=0 && y < n && isLand[x][y]) {
						uf.union(pos[0], pos[1], x, y);
					}
				}
			}
			ret.add(uf.count);
		}
		return ret;
    }

	class UnionFind {
		int m;
		int n;
		int count;
		int[] parent;

		UnionFind(int m, int n) {
			this.m = m;
			this.n = n;
			this.count = 0;
			this.parent = new int[m*n];
		}

		void makeSet (int i, int j) {
			int idx = i*n + j;
			parent[idx] = idx;
			count++;
		}

		void union (int x1, int y1, int x2, int y2) {
			int idx1 = x1*n + y1;
			int idx2 = x2*n + y2;
			int r1 = find(idx1);
			int r2 = find(idx2);

			if (r1 != r2) {
				parent[r1] = r2;
				count--;
			}
		}

		int find (int idx) {
			if (parent[idx] == idx) {
				return idx;
			}
			parent[idx] = find(parent[idx]);
			return parent[idx];
		}
	}
}
