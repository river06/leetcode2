class Solution {
    public int findCircleNum(int[][] M) {
        // edge cases
		if (M == null || M.length == 0 || M[0].length == 0) {
			return 0;
		}
		int n = M.length;
		UnionFind uf = new UnionFind(n);

		for (int i=0; i<n; i++) {
			uf.makeSet(i);
		}
		
		for (int i=0; i<n; i++) {
			for (int j =i+1; j<n; j++) {
				if (M[i][j] == 1) {
					uf.union(i, j);
				}
			}
		}

		return uf.counter;
    }

	class UnionFind {
		int counter;
		int[] parent;

		UnionFind (int n) {
			this.counter = 0;
			this.parent = new int[n];
		}

		void makeSet(int i) {
			this.counter++;
			this.parent[i] = i;
		}

		void union(int i, int j) {
			int ri = find(i);
			int rj = find(j);
			if (ri != rj) {
				this.parent[ri] = rj;
				this.counter--;
			}
		}

		int find (int i) {
			if (this.parent[i] == i) {
				return i;
			}
			this.parent[i] = find(this.parent[i]);
			return this.parent[i];
		}
	}
}
