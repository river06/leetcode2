import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
        int[][] board = {{1,0,1},{1,1,0}};
        solver.gameOfLife(board);
        
        for(int i=0; i<board.length; i++) {
            for(int j =0; j<board[0].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }

	}
}
