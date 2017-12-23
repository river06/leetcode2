import java.util.*;
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);

		for (int[] edge: edges) {
			if (uf.find(edge[0]) == uf.find(edge[1])) {
				return edge;
			}
			uf.union(edge[0], edge[1]);
		}
		return new int[] {-1, -1};
    }

	class UnionFind {
		int[] parents;
		int[] weights;
		UnionFind (int n) {
			this.parents = new int[n];
			for (int i=0; i<n; i++) {
				this.parents[i] = i;
			}

			this.weights = new int[n];
			Arrays.fill(this.weights, 1);
		}

		int find(int v) {
			if (this.parents[v] == v) {
				return v;
			}
			this.parents[v] = find(this.parents[v]);
			return this.parents[v];
		}

		void union(int v1, int v2) {
			int r1 = find(v1);
			int r2 = find(v2);

			if (r1 != r2) {
				if (this.weights[r1] > this.weights[r2]) {
					this.parents[r2] = r1;
					this.weights[r1] += this.weights[r2];
				} else {
					this.parents[r1] = r2;
					this.weights[r2] += this.weights[r1];
				}
			}
		}
	}
				
}
