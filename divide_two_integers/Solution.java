public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
		if(divisor == Integer.MIN_VALUE) {
			if(dividend == Integer.MIN_VALUE) {
				return 1;
			}else{
				return 0;
			}
		}
		int sign = 1;
		if( ( dividend < 0 && divisor > 0 ) || (dividend>0&&divisor<0)){
			sign = -1;
		}
		int divisor_abs = Math.abs(divisor);
		if( dividend == Integer.MIN_VALUE ) {
			if( divisor == -1 ) {
				// over flow
				return Integer.MAX_VALUE;
			} else {
				int tmp = dividend + divisor_abs;
				int ret = divide(Math.abs(tmp), divisor_abs) + 1;
				if(sign == -1) ret = -ret;
				return ret;
			}
		}

		int dividend_abs = Math.abs(dividend);
			
		if(dividend_abs < divisor_abs) return 0;

		
		int n = 0;
		int tmp = dividend_abs;
		while(true) {
			if( tmp < divisor_abs) {
				break;
			}
			tmp = tmp>>1;
			n++;
		}

		int ret = 1<<(n-1);
		ret += divide( dividend_abs - (divisor_abs<<(n-1)), divisor_abs);
		if(sign==-1) ret = -ret;
		return ret;
    }
}
