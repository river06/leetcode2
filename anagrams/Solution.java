import java.util.*;
public class Solution {
    public List<String> anagrams(String[] strs) {
        // this problem is not very clear...
		List<String> ret = new ArrayList<String>();
		if(strs == null || strs.length == 0) return ret;
		
		Map<String, List<String> > ana_map = new HashMap<String, List<String>>();
		for(int i=0; i<strs.length; i++) {
			char[] tmp_arry = strs[i].toCharArray();
			Arrays.sort(tmp_arry);
			String sorted_str = new String( tmp_arry );
			
			if( ana_map.containsKey( sorted_str ) ) {
				ana_map.get( sorted_str ).add( strs[i] );
			} else {
				List<String> new_set = new ArrayList<String>();
				new_set.add( strs[i] );
				ana_map.put(sorted_str, new_set);
			}
		}
		
		// convert to results
		for( List<String> str_set : ana_map.values() ) {
			if( str_set.size() > 1 ) {
				ret.addAll( str_set );
			}
		}
		return ret;
    }
}