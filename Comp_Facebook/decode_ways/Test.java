import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] strs ={"12", "01"};
		for (String str: strs) {
			int ret = solver.numDecodings(str);
			
			System.out.println(str + ": " + ret);
		}
	}
}
