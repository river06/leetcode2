class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) { return x; }
		int l = 1;
		int r = x;
		while (l < r) {
			int m = (l+r)/2;
			if (x/m == m || (x/m>m && x/(m+1)<(m+1))) {
				return m;
			} else if (x/m > m) {
				l = m+1;
			} else {
				r = m-1;
			}
		}
		return l;
    }
}
