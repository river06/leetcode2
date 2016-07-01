/* The isBadVersion API is defined in the parent class VersionControl.
 boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(!isBadVersion(n)) return -1;
        
        return helper(1,n);
    }
    private int helper(int idxl, int idxr) {
        if(idxr == idxl) return idxl;
        
        int idxm = idxl+(idxr-idxl)/2;
        
        return isBadVersion(idxm) ? helper(idxl,idxm) : helper(idxm+1,idxr);
    }
}