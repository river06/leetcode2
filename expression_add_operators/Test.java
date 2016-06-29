import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String num = "123";
		//int target = 6;
		//String num = "232";
		//int target = 8;
		//String num = "105";
		//int target = 5;
		//String num = "00";
		//int target = 0;
		String num = "3456237490";
		int target = 9191;
		//String num = "2147483648";
		//int target = -2147483648;

		List<String> ret = solver.addOperators(num, target);
		for(String str: ret) {
			System.out.println(str);
		}
	}
}
