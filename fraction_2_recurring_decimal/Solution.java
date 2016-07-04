import java.util.*;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if( denominator == 0) return null;
		int sign = 1;
		if( (numerator<0 && denominator>0 ) ||
			(numerator>0 && denominator<0 ) ) sign = -1;
		
		long dem = Math.abs( (long) denominator );
		long num = Math.abs( (long) numerator );
		
		long int_part = num/dem;
		String int_part_str = Long.toString(int_part);

		long rem_part = num % dem;

		String frac_part_str = new String();

		Hashtable<Long,Integer> rem_hash = new Hashtable<Long,Integer>();
		
		int idx = 0;
		while( rem_part != 0 && !rem_hash.containsKey(rem_part) ) {
			rem_hash.put( rem_part, idx );
			rem_part *= 10;
			int_part = rem_part/dem;
			rem_part = rem_part % dem;
			frac_part_str += Long.toString(int_part);
			idx ++;
		}
		String ret;
		if( rem_hash.isEmpty() ) {
			// return integer
			ret = int_part_str;
		} else if (rem_part == 0 ) {
			// return zheng chu
			ret = int_part_str + "." + frac_part_str;
		} else {
			// return chong fu
			int idx_start = rem_hash.get( rem_part );
			String part1 = frac_part_str.substring(0,idx_start);
			String part2 = frac_part_str.substring
				(idx_start, frac_part_str.length() );
			ret = int_part_str + "." + part1 + "(" + part2 + ")";
		}
		if(sign == -1) ret = "-" + ret;
		return ret;
    }
}
