public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
		// backward DP
		int n_row = dungeon.length;
		int n_col = dungeon[0].length;
		int[][] hp = new int[n_row][n_col];
									  
		for(int i=n_row-1; i>=0; i--) {
			for(int j=n_col-1; j>=0; j--) {
				if(i==n_row-1 && j==n_col-1){
					hp[i][j] = Math.max(1-dungeon[i][j],1);
				}else{
					int hp_row = Integer.MAX_VALUE;
					int hp_col = Integer.MAX_VALUE;
					if(i<n_row-1) {
						hp_col = Math.max(1,hp[i+1][j]-dungeon[i][j]);
					}
					if(j<n_col-1) {
						hp_row = Math.max(1,hp[i][j+1]-dungeon[i][j]);
					}
					hp[i][j] = Math.min(hp_row,hp_col);
					hp[i][j] = Math.max( hp[i][j], 1);
				}
			}
		}
		return hp[0][0];
    }
}
