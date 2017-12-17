import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String task = "AAABBB";
		int n = 2;
		int ret = solver.leastInterval(task.toCharArray(), n);
		System.out.println(ret);
	}
}
