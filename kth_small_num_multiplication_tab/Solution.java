class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1;
		int r = m*n;

		while (l < r) {
			int mid = l + (r-l)/2;
			int[] pos = findPos(m, n, mid);
			if (pos[0]+1<=k && pos[1]>=k) {
				return mid;
			} else if (pos[1] < k) {
				l = mid+1;
			} else {
				r = mid-1;
			}
		}

		return l;
    }

	private int[] findPos(int m, int n, int x) {
		// pos[0]: number of elements smaller than x
		// pos[1]: number of elements not greater than x
		int row = 1;
		int col = n;
		int num0 = 0;
		int num1 = 0;
		while (row <= m && col > 0) {
			if (row*col <= x) {
				num0 += col;
				num1 += col;
				if (row*col == x) { num0--; }
				row++;
			} else {
				col--;
			}
		}
		int[] ret = {num0, num1};
		return ret;
	}
}
