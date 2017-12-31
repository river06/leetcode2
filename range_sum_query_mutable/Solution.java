class NumArray {
	SegmentTree segmentTree;
    public NumArray(int[] nums) {
		if (nums.length == 0) { return; }
        this.segmentTree = new SegmentTree(nums);
    }
    
    public void update(int i, int val) {
        this.segmentTree.update(i, val);
    }
    
    public int sumRange(int i, int j) {
        return this.segmentTree.sumRange(i, j);
    }

	/** water down version of segment tree */
	class SegmentTree {
		int[] tree;
		int n;
		SegmentTree(int[] nums) {
			this.n = nums.length;
			int l = getLength(n);
			this.tree = new int[l];
			buildTree(nums, 0, n-1, 0);
		}

		void update(int idx, int val) {
			updateTree(idx, val, 0, n-1, 0);
		}

		int sumRange(int s, int e) {
			return sumRange(s, e, 0, n-1, 0);
		}

		private int getLength(int length) {
			int ret = 1;
			while (ret < length) {
				ret *= 2;
			}
			return ret*2 - 1;
		}

		private void buildTree(int[] nums, int l, int r, int root) {
			if (l == r) {
				this.tree[root] = nums[l];
				return;
			}

			int m = (r-l)/2 + l;
			buildTree(nums, l, m, root*2+1);
			buildTree(nums, m+1, r, root*2+2);
			this.tree[root] = this.tree[root*2+1] + this.tree[root*2+2];
		}

		private void updateTree(int idx, int val, int l, int r, int root) {
			if (idx < l || idx > r) {
				return;
			}
			if (l == r) {
				this.tree[root] = val;
				return;
			}

			int m = (r-l)/2 + l;

			updateTree(idx, val, l, m, root*2 + 1);
			updateTree(idx, val, m+1, r, root*2 + 2);
			this.tree[root] = this.tree[root*2+1] + this.tree[root*2+2];
		}

		private int sumRange(int s, int e, int l, int r, int root) {
			if (s <= l && e >= r) {
				return this.tree[root];
			}

			if (s > r || e < l) {
				return 0;
			}

			int m = (r-l)/2 + l;
			int lSum = sumRange(s, e, l, m, root*2+1);
			int rSum = sumRange(s, e, m+1, r, root*2+2);
			return lSum + rSum;
		}
	}
}
