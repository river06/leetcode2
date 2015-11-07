import java.util.*;
public class Solution {
    public String convertToTitle(int n) {
		String ret = new String();
		Stack<Character> stack = new Stack<Character>();
		int base = 26;
		while(n > 0){
			int num = n%base;
			if(num == 0) num = base;
			char c = (char)('A' + (num -1));
			stack.push(c);
			n-=num;
			n/=base;
		}
		while(!stack.isEmpty()) {
			ret += stack.pop();
		}
		return ret;
    }
}
