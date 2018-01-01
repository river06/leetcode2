import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String ring = "godding";
		String key = "gd";
		/*String ring = "pqwcx";
		String key = "cpqwx";*/

		int ret = solver.findRotateSteps(ring, key);

		System.out.println(ret);
	}
}
