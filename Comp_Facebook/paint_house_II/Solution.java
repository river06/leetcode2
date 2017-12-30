import java.util.*;
class Solution {
    public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0) {
			return 0;
		}
		int m = costs.length;
		int n = costs[0].length;
		int[] prevCost = new int[n];

		for (int i=0; i<m; i++) {
			int[] currCost = new int[n];
			int[] minCostColor = getMinCostColor(prevCost);
			int minCost = prevCost[minCostColor[0]];
			int secCost = prevCost[minCostColor[1]];
			for (int j=0; j<n; j++) {
				currCost[j] += costs[i][j];
				currCost[j] += (j == minCostColor[0]) ? secCost : minCost;
			}
			prevCost = currCost;
		}
		
		int ret = Integer.MAX_VALUE;
		for (int cost: prevCost) {
			ret = Math.min(ret, cost);
		}

		return ret;
    }

	private int[] getMinCostColor(int[] costs) {
		int idx1 = -1;
		
		int minCost = Integer.MAX_VALUE;
		for (int i=0; i<costs.length; i++) {
			if (costs[i] < minCost) {
				idx1 = i;
				minCost = costs[i];
			}
		}
		int idx2 = idx1;
		
		minCost = Integer.MAX_VALUE;
		for (int i=0; i<costs.length; i++) {
			if (i != idx1 && costs[i] < minCost) {
				idx2 = i;
				minCost = costs[i];
			}
		}

		return new int[] {idx1, idx2};
	}
}
