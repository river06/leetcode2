/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 0) { return -1; }
        
        // find end of any path
        boolean[] isNotCelebrity = new boolean[n];
        int candidate = 0;
        while (true) {
            boolean isFound = true;
            for (int i=0; i<n; i++) {
                if (i != candidate && !isNotCelebrity[i] && knows(candidate, i)) {
                    candidate = i;
                    isNotCelebrity[candidate] = true;
                    isFound = false;
                    break;
                }
            }
            if (isFound) { break; }
        }

        // determine if the guy is the celebrity
        for (int i=0; i<n; i++) {
			
            if (i!=candidate && (knows(candidate, i) || !knows(i, candidate))) {
				return -1;
			}
        }
        
        return candidate;
    }
}
