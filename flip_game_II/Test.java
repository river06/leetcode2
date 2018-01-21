import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String s = "++++";
		String[] ss = {"++--", "++++",
					   "+-++-+++-++++-+++++-+-+-+-+-+-+-+-+-+-+-+"};
		boolean[] results = { true, true, true };
		for (int i=0; i<ss.length; i++) {
			boolean ret = solver.canWin(ss[i]);

			System.out.println(ss[i]);
			System.out.println(results[i]);
			System.out.println("my result is: " + ret);
			System.out.println("  ");
		}
	}
}
