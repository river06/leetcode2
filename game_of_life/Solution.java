import java.util.*;

public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count = getNeighbor(board, m,n, i,j);
                if(board[i][j] == 0) {
                    if(count==3) board[i][j] = 2; // 10
                } else { // board[i][j] = 1
                    if( count>=2 && count<=3) board[i][j] = 3; //11
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j]>>=1;
            }
        }
    }
    
    private int getNeighbor(int[][] board, int m, int n, int i, int j){
        int count = 0;
        for(int ii=i-1; ii<=i+1; ii++) {
            for(int jj= j-1; jj<=j+1; jj++) {
                if( (i != ii || j!= jj) && ii>=0 && ii<m && jj>=0 && jj<n) {
                    count += board[ii][jj]&1;
                }
            }
        }
        return count;
    }
}