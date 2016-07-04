import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] numerator = {1,2,2,-2,4,1};
		int[] denominator = {2,1,3,3,9,6};
		for(int i = 0; i<numerator.length; i++) {
			System.out.print("num: " + Integer.toString(numerator[i]));
			System.out.println(" deno: "+ Integer.toString(denominator[i]));
			System.out.println(
				solver.fractionToDecimal(numerator[i], denominator[i]));
		}
	}
}
