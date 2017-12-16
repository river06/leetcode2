import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		char[] letters = {'a', 'b'};
		char target = 'a';
		char ret = solver.nextGreatestLetter(letters, target);
		System.out.println(ret);
	}
}
