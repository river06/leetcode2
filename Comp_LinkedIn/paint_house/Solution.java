public class Solution {
    /*
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		for (int i=1; i<costs.length; i++) {
			for (int j=0; j<3; j++) {
				int cost = Integer.MAX_VALUE;
				
				for (int k=0; k<3; k++) {
					if (k != j) {
						cost = Math.min(cost, costs[i][j] + costs[i-1][k]);
					}
				}
				costs[i][j] = cost;
			}
		}

		int ret = costs[costs.length-1][0];
		for (int i=1; i<3; i++) {
			ret = Math.min(ret, costs[costs.length-1][i]);
		}
		return ret;
    }
}
