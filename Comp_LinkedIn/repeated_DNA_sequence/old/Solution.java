import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<String>();

		if (s == null || s.length() <10) { return ret; }

		// initialize
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Character, Integer> char2Num = new HashMap<Character, Integer>();
		char2Num.put('A', 0);
		char2Num.put('C', 1);
		char2Num.put('G', 2);
		char2Num.put('T', 3);

		int sequence = 0;
		for (int i=0; i<10; i++) {
			sequence += (char2Num.get(s.charAt(i)) << (i*2));
		}

		map.put(sequence, 1);

		for (int i=10; i<s.length(); i++) {
			sequence = sequence >> 2;
			sequence += (char2Num.get(s.charAt(i)) << 18);

			if (map.containsKey(sequence)) {
				if (map.get(sequence) == 1) {
					ret.add( s.substring(i-9, i+1) );
					map.put(sequence, 2);
				}
			} else {
				map.put(sequence, 1);
			}
		}
		
		return ret;
    }
}
