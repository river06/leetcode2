import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] ss = {"*", "1*", "122", "123", "213", "273",
					   "**", "*1*1*0", "*1*1*", "**********1111111111"};
		for (String s: ss) {
			System.out.println("string: " + s);
			int ret = solver.numDecodings(s);
			
			System.out.println(ret);
		}
	}
}
