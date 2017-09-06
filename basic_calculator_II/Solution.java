import java.util.*;

class Solution {
    public int calculate(String s) {
        if ( s==null || s.length() == 0 ) { return 0; }
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		boolean isFirst = true;

		boolean isMultiply = true;
		int i = 0;
		while ( i<s.length() ) {
			char c = s.charAt(i);
			switch (c) {
			case ' ':
				break;
			case '+':
				stack.push(1);
				isMultiply = true;
				break;
			case '-':
				if (isFirst) { stack.pop(); }
				stack.push(-1);
				isMultiply = true;
				break;
			case '*':
				isMultiply = true;
				break;
			case '/':
				isMultiply = false;
				break;
			default:
				isFirst = false;
				int curNum = 0;
				while( i<s.length() && s.charAt(i) >='0' && s.charAt(i) <='9') {
					curNum = curNum*10 + s.charAt(i) - '0';
					i++;
				}
				int left = stack.pop();
				if (isMultiply) {
					curNum *= left;
				} else {
					curNum = left / curNum;
				}
				stack.push(curNum);
				i--;
			}
			i++;
		}

		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
    }
}
