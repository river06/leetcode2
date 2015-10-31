import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String input = "2-1-1";
		String input = "2*3-4*5";
		List<Integer> ret = solver.diffWaysToCompute(input);
		for(Integer a:ret){
			System.out.println(a);
		}
	}
}
