class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // find the possible edges pointing to the same node
		int n = edges.length+1;
		int[] parents = new int[n];
		int[] edge1 = new int[2];
		int[] edge2 = new int[2];
		int invalidEdge = -1;
		for (int i=0; i<edges.length; i++) {
			int[] edge = edges[i];
			if (parents[edge[1]] != 0) {
				edge1 = new int[] {parents[edge[1]], edge[1]};
				edge2 = edge;
				invalidEdge = i;
				break;
			}
			parents[edge[1]] = edge[0];
		}

		// UnionFind
		UnionFind uf = new UnionFind(n);
		for (int i=0; i<edges.length; i++) {
			if (i == invalidEdge) { continue; }
			int[] edge = edges[i];

			if (uf.find(edge[0]) == uf.find(edge[1])) {
				if (invalidEdge == -1) {
					return edge;
				} else {
					return edge1;
				}
			}

			uf.union(edge[0], edge[1]);
		}

		return edge2;
    }

	class UnionFind {
		int[] parents;
		
		UnionFind(int n) {
			this.parents = new int[n];
			for (int i=0; i<n; i++) {
				this.parents[i] = i;
			}
		}

		int find(int v) {
			if (this.parents[v] == v) {
				return v;
			}

			this.parents[v] = find(this.parents[v]);
			return this.parents[v];
		}

		void union(int p, int c) {
			int rp = find(p);
			int rc = find(c);
			if (rp != rc) {
				this.parents[rc] = rp;
			}
		}

	}
}
