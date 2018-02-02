import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int n = 8;
		List<List<String>> rets = solver.solveNQueens(n);
		for (List<String> ret: rets) {
			for (String row: ret) {
				char[] charArr = row.toCharArray();
				for (int i=0; i<charArr.length; i++) {
					System.out.print(charArr[i] + " ");
				}
				System.out.println("");
			}
			System.out.println("------------");
		}
	}
}
