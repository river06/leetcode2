import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String licensePlate = "1s3 PSt";
		//String[] words = {"step", "steps", "stripe", "stepple"};
		String licensePlate = "1s3 456";
		String[] words = {"looks", "pest", "stew", "show"};
		String ret = solver.shortestCompletingWord(licensePlate, words);
		System.out.println(ret);
	}
}
