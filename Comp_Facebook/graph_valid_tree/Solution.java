class Solution {
    public boolean validTree(int n, int[][] edges) {
        // this is union find algorithm
		UnionFind uf = new UnionFind(n);

		for (int i=0; i<n; i++) {
			uf.makeSet(i);
		}

		for (int[] edge: edges) {
			if (uf.find(edge[0]) == uf.find(edge[1])) {
				return false;
			}

			uf.union(edge[0], edge[1]);
		}

		return (uf.counter == 1);
    }

	class UnionFind {
		int[] parent;
		int counter;
		UnionFind (int n) {
			this.parent = new int[n];
			this.counter = 0;
		}

		public void makeSet(int i) {
			parent[i] = i;
			this.counter++;
		}

		public void union(int i, int j) {
			int ri = find(i);
			int rj = find(j);

			if (ri != rj) {
				parent[ri] = rj;
				this.counter--;
			}
		}

		public int find(int i) {
			if (parent[i] == i) {
				return i;
			}
			parent[i] = find(parent[i]);
			return parent[i];
		}
		
	}
}
