import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
        for(int i=2; i<58; i++) {
            System.out.print(solver.integerBreak(i) + " ");
        }
	}
}
