import java.util.*;
public class SolutionOT {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new LinkedList<String>();
		List<String> cand = findAllString(num);
		for(String str:cand) {
			if( evalStr(str) == target) {
				ret.add(str);
			}
		}
		return ret;
    }
	long evalStr(String str) {
		LinkedList<Long> num = new LinkedList<Long>();
		LinkedList<Character> op = new LinkedList<Character>();
		int start = 0;
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)<'0' || str.charAt(i)>'9') {
				num.add(Long.parseLong( str.substring(start,i)));
				op.add( str.charAt(i) );
				start = i+1;
			}
		}
		num.add(Long.parseLong( str.substring(start,str.length())));

		long ret = num.poll();
		long change = ret;
		while( !op.isEmpty()) {
			long int_now = num.poll();
			char op_now = op.poll();
			if( op_now == '+' ){
				ret += int_now;
				change = int_now;
			}else if(op_now == '-'){
				ret = ret - int_now;
				change = -int_now;
			}else {
				ret = ret - change;
				change *= int_now;
				ret += change;
			}
		}
		return ret;
						
	}
	
	List<String> findAllString(String num) {
		List<String> ret = new LinkedList<String>();
		if(num==null || num.length() == 0) return ret;
		for(int i=1; i<num.length(); i++) {
			String l_str = num.substring(0,i);
			if(l_str.charAt(0) == '0' && i>1) break;
			List<String> r_str_list =
				findAllString(num.substring(i,num.length()));
			
			for(String r_str:r_str_list) {
				String tmp1 = new String( l_str + "+" + r_str);
				String tmp2 = new String( l_str + "-" + r_str);
				String tmp3 = new String( l_str + "*" + r_str);
				ret.add(tmp1);
				ret.add(tmp2);
				ret.add(tmp3);
			}
		}
		if( num.charAt(0) != '0' || num.length()<=1) {
			ret.add(num);
		}
		return ret;
	}
		
}
