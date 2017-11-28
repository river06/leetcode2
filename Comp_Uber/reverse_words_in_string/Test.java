import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String str = "the";
		String str = "the sky is blue";
		char[] charArr = str.toCharArray();
		solver.reverseWords(charArr);
		System.out.println(new String(charArr));
	}
}
