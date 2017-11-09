/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // mat[i][j] = 1: i knows j; -1 i does not know j; 0 no judgement yet
		int[][] mat = new int[n][n];

		for (int i=0; i<n; i++) {
			boolean isCelebrity = true;
			
			// judge if anyone does not know me based on previous results
			// judge if I already know any one based on previous results
			for (int j=0; j<i; j++) {
				if (mat[i][j] == 1 || mat[j][i] == -1) {
					isCelebrity = false;
					break;
				}
			}
			if (!isCelebrity) { continue; }

			// judge if anyone does not know me
			for (int j=0; j<n; j++) {
				if (j != i && mat[j][i] == 0) {
					mat[j][i] = knows(j, i) ? 1 : -1;
					if (mat[j][i] == -1) {
						isCelebrity = false;
						break;
					}
				}
			}
			if (!isCelebrity) { continue; }

            // judge if I already know any one
			for (int j=0; j<n; j++) {
				if (j != i && mat[i][j] == 0) {
					mat[i][j] = knows(i, j) ? 1 : -1;
					if (mat[i][j] == 1) {
						isCelebrity = false;
						break;
					}
				}
			}

			if (isCelebrity) { return i; }
		}

		return -1;
    }
}
