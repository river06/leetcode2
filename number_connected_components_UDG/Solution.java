import java.util.*;
class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
		for (int[] edge: edges) {
			uf.union(edge[0], edge[1]);
		}
		return uf.counter;
    }

	class UnionFind {
		int[] parents;
		int counter;
		int[] weights;
		UnionFind(int n) {
			this.parents = new int[n];
			for (int i=0; i<n; i++) {
				this.parents[i] = i;
			}
			this.weights = new int[n];
			Arrays.fill(this.weights, 1);
			this.counter = n;
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
				this.counter--;
			}
		}
	}
}
