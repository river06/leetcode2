class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length; // number of cities
		int K = days[0].length; // number of weeks

		int[][] dp = new int[N][K]; // number of max vacation days at city i week j

		// initialize
		dp[0][0] = days[0][0];
		for (int i=1; i<N; i++) {
			if (flights[0][i] == 1) {
				dp[i][0] = days[i][0];
			} else {
				dp[i][0] = -1; // can not be here
			}
		}

		for (int k=1; k<K; k++) {
			for (int i=0; i<N; i++) {
				int maxHoliday = -1;
				for (int j=0; j<N; j++) {
					if (dp[j][k-1] != -1 && (flights[j][i] == 1 || j==i)) {
						maxHoliday = Math.max(maxHoliday, dp[j][k-1] + days[i][k]);
					}
				}
				dp[i][k] = maxHoliday;
			}
		}
		int ret = 0;
		for (int i=0; i<dp.length; i++) {
			ret = Math.max(ret, dp[i][K-1]);
		}
		return ret;
    }
}
