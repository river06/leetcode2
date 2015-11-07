import java.util.*;
public class Solution {
    public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<tokens.length; i++) {
			if(tokens[i].equals("+")||tokens[i].equals("-")||
			   tokens[i].equals("*")||tokens[i].equals("/")) {
				int int2 = stack.pop();
				int int1 = stack.pop();
				int ret = calValue(int1, int2, tokens[i]);
				stack.push(ret);
			} else {
				stack.push( Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
		
    }
	int calValue(int int1, int int2, String op){
		int ret=0;
		if(op.equals("+")) ret = int1 + int2;
		if(op.equals("-")) ret = int1 - int2;
		if(op.equals("*")) ret = int1 * int2;
		if(op.equals("/")) ret = int1 / int2;
		return ret;
	}
}
