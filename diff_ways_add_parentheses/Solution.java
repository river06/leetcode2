import java.util.*;
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
		// divide and conquer ?
		List<Integer> ret = new LinkedList<Integer>();
		int in_len = input.length();
		for(int i=0; i<input.length(); i++){
			char c = input.charAt(i);
			if(c=='+' || c=='-' || c=='*' ) {
				List<Integer> ret_l =
					diffWaysToCompute(input.substring(0,i));
				List<Integer> ret_r =
					diffWaysToCompute(input.substring(i+1,in_len));
				for(int l: ret_l) {
					for(int r: ret_r) {
						switch(c) {
						case '+': ret.add(l+r); break;
						case '-': ret.add(l-r); break;
						case '*': ret.add(l*r); break;
						default: break;
						}
					}
				}
			}
		}
		if(ret.isEmpty()) {
			ret.add( Integer.parseInt( input) );
		}
		return ret;							  
	}

	
}
