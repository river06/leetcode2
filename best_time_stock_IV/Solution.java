public class Solution {
    public int maxProfit(int k, int[] prices) {
		// this solution is copied from the internet
		// the best solution I have seen
		// elegant with the spirit of DP
		// time complexity: O(n*k)
		// space complexity: O(n*k), can be reduced to O(n)
		// best(k,i): the maximum profit up to the ith price, if at
		//            most k transactions are allowed
		// best(k,i) = max{ best(k,i-1), max[best(k-1,j) + price(i)-price(j)] }
		//           = max{ best(k,i-1), price(i) + max[best(k-1,j) - price(j)] }
		// best(0,:) = 0, no money can be made by 0 transactions
		// best(:,0) = 0, one price does not make any money

		int nPrice = prices.length;
		if(nPrice<2 && k<1) return 0;

		int ret = 0;
		if( k > nPrice/2) {
			// O(n) solution for this case
			for(int i=1; i<nPrice; i++) {
				if( prices[i] > prices[i-1] ) {
					ret += prices[i] - prices[i-1];
				}
			}
		} else {
			int[][] best = new int[k+1][nPrice]; // we can rely on java 
			for(int kk=1; kk<=k; kk++) {
				int tmp_max = best[kk-1][0] - prices[0];
				for(int jj = 1; jj<nPrice; jj++) {
					best[kk][jj] = Math.max( best[kk][jj-1], prices[jj] + tmp_max);
					tmp_max = Math.max(tmp_max, best[kk-1][jj] - prices[jj]);
					ret = Math.max(ret, best[kk][jj]);
				}
			}
		}
		return ret;
    }
}