import java.util.*;
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int m = gas.length;
        int[] gas_cir = new int[2*m];
        for(int i=0; i<m; i++) {
            gas_cir[i] = gas[i] - cost[i];
            gas_cir[i+m] = gas_cir[i];
        }
        
        int idx1 = 0;
        int idx2 = 0;
        
        int sum = 0;
        while(idx1 < m ) {
            if( idx2 - idx1 == m) return idx1;
            sum += gas_cir[idx2];
            if(sum < 0) {
                sum = 0;
                idx1 = idx2+1;
            }
            idx2++;
        }

        return -1;
    }
}