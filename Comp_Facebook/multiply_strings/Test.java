import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[][] nums = {
			{"1", "2"}, {"9", "9"}, {"84", "8"}, {"8", "84"},
			{"632", "89"}, {"999", "999"}, {"9999", "99"}, {"99", "9999"}
		};
		for (String[] num: nums) {
			String ret = solver.multiply(num[0], num[1]);
			System.out.println(num[0] + " x " + num[1] +" = " + ret);
		}
	}
}
