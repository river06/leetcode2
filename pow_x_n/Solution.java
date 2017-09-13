class Solution {
    public double myPow(double x, int n) {
		if (x == 0) { return n == 0 ? 1 : 0; }
		boolean isNegPow = n < 0 ? true : false;

		if (isNegPow) { x = 1/x; }

		double result = 1;
		if ( n == Integer.MIN_VALUE ) {
			n += 1;
			result *= x;
		}

		if (isNegPow) { n = -n; }

		while ( n > 0 ) {
			if ( (n & 1) == 1 ) {
				result *= x;
			}

			x *= x;
			n = n >> 1;
		}

		// if (isNegPow) { result = 1/result; }

		return result;
		
    }
}
