public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if( denominator == 0) return null;
		int sign = 1;
		if( (numerator<0 && denominator>0 ) ||
			(numerator>0 && denominator<0 ) ) sign = -1;
		
		long dem = Math.abs( (long) denominator );
		long num = Math.abs( (long) numerator );
		
		long int_part = num/dem;

		long rem_part = num % dem;

		String frac_part = new String();

		HashTable<Long> rem_hash = new HashTable<Long>();
		
		while( rem_part != 0 && !rem_hash.contains(rem_part) ) {
			rem_hash.add( rem_part );

			rem_part *= 10;

			int_part = rem_part/dem;

			rem_part = rem_part % dem;

			frac_part.add(int_part);
			
		}

		if( rem_hash.empty() ) {
			// return integer
		} else if (rem_part == 0 ) {
			// return zheng chu
		} else {
			// return chong fu
		}
    }
}
