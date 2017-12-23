class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;
		int[][] dir = {{1, 0}, {0, 1}};
		UnionFind uf = new UnionFind(m, n);

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				uf.makeSet(i, j);
			}
		}
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (board[i][j] == 'O') {
					for (int[] d: dir) {
						int ni = i+d[0];
						int nj = j+d[1];

						if (ni >= 0 && ni < m && nj >= 0 && nj < n &&
							board[ni][nj] == 'O') {
							uf.union(i, j, ni, nj);
						}
					}
				}
			}
		}

		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (board[i][j] == 'O') {
					if (uf.getIsSurrounded(i, j)) {
						board[i][j] = 'X';
					}
				}
			}
		}
    }

	class UnionFind {
		int[] parent;
		boolean[] isSurrounded;
		int m;
		int n;
		UnionFind (int m, int n) {
			this.m = m;
			this.n = n;
			this.parent = new int[m*n];
			this.isSurrounded = new boolean[m*n];
		}

		boolean getIsSurrounded(int i, int j) {
			int r = find(getIdx(i, j));
			return this.isSurrounded[r];
		}

		int find(int r) {
			if (this.parent[r] == r) {
				return r;
			}
			this.parent[r] = find(this.parent[r]);
			return this.parent[r];
		}

		void union(int i1, int j1, int i2, int j2) {
			int idx1 = getIdx(i1, j1);
			int idx2 = getIdx(i2, j2);
			int r1 = find(idx1);
			int r2 = find(idx2);

			if (r1 != r2) {
				this.parent[r1] = r2;
				this.isSurrounded[r2] = this.isSurrounded[r2] && this.isSurrounded[r1];
			}
		}

		void makeSet(int i, int j) {
			int idx = getIdx(i, j);
			this.parent[idx] = idx;
			this.isSurrounded[idx] = (i==0 || i==m-1 || j==0 || j==n-1) ? false : true;
		}

		int getIdx(int i, int j) {
			return i*this.n + j;
		}
	}
				
}
