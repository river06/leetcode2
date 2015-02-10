import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int L = 16;
		
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		ArrayList<String> ret = solver.fullJustify(words, L);
		
		for(int i=0; i<ret.size(); i++) {
			System.out.print(ret.get(i) );
			System.out.println("|");
		}
	}
}