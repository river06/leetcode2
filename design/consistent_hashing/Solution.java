import java.util.*;

public class Solution {
    /*
     * @param n: a positive integer
     * @return: n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
		if (n==1) {
			List<Integer> s1 = new ArrayList<Integer>();
			s1.add(0);
			s1.add(359);
			s1.add(1);
			List<List<Integer>> map = new ArrayList<List<Integer>>();
			map.add(s1);
			return map;
		} 

		List<List<Integer>> map = consistentHashing(n-1);

		// find the largest sector
		List<Integer> sector = map.get(0);
		for (int i=1; i<map.size(); i++) {
			List<Integer> tmp = map.get(i);
			if (tmp.get(1) - tmp.get(0) > sector.get(1) - sector.get(0)) {
				sector = tmp;
			}
		}

		int x = sector.get(0);
		int y = sector.get(1);
		int z = sector.get(2);
		sector.remove(1);
		sector.add(1, (x+y)/2);

		List<Integer> newSector = new ArrayList<Integer>();
		Collections.addAll(newSector, (x+y)/2+1, y, n);

		map.add(newSector);
		
		return map;
    }

	
}
