import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		// case 1
		/*int[][] envelopes = {
			{5,4}, {6,4}, {6,7}, {2,3}
		};*/

		/*int[][] envelopes = {
			{30,50}, {12,2}, {3,4}, {12,15}
		};*/

		int[][] envelopes = {
			{4,5}, {4,6}, {6,7}, {2,3}, {1,1}
		};

		int ret = solver.maxEnvelopes(envelopes);

		System.out.println(ret);
	}
}
