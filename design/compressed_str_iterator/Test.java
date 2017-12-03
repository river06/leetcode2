import java.util.*;
public class Test {
	public static void main(String[] args) {
		//String str = "L1e2t1C1o1d1e1";
		String str = "L11e2t1C1o1d1e1";
		StringIterator iterator = new StringIterator(str);
		
		iterator.next(); // return 'L'
		iterator.next(); // return 'e'
		iterator.next(); // return 'e'
		iterator.next(); // return 't'
		iterator.next(); // return 'C'
		iterator.next(); // return 'o'
		iterator.next(); // return 'd'
		iterator.next(); // return 'L'
		iterator.next(); // return 'e'
		iterator.next(); // return 'e'
		iterator.next(); // return 't'
		iterator.next(); // return 'C'
		iterator.next(); // return 'o'
		iterator.next(); // return 'd'
		iterator.next(); // return 'L'
		iterator.next(); // return 'e'
		iterator.next(); // return 'e'
		iterator.next(); // return 't'
		iterator.next(); // return 'C'
		iterator.next(); // return 'o'
		iterator.next(); // return 'd'
		iterator.hasNext(); // return true
		iterator.next(); // return 'e'
		iterator.hasNext(); // return false
		iterator.next(); // return ' '
	}
}
