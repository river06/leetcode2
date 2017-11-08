public class Solution {
    /*
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) { return 0; }
		for (int i=1; i<costs.length; i++) {
			for (int j=0; j<costs[0].length; j++) {
				int costPre = Integer.MAX_VALUE;
				for (int k=0; k<costs[0].length; k++) {
					if (k != j) {
						costPre = Math.min(costPre, costs[i-1][k]);
					}
				}
				costs[i][j] += costPre;
			}
		}
		int ret = Integer.MAX_VALUE;
		for (int i=0; i<costs[0].length; i++) {
			ret = Math.min(ret, costs[costs.length-1][i]);
		}

		return ret;
    }
}
