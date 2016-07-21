import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        int n_house = nums.length;
		if(n_house <= 0) return 0;
		if(n_house == 1) return nums[0];

		// case 1: rob first house
		int[] money_1 = new int[n_house];
		money_1[0] = nums[0];
		money_1[1] = nums[0];
		for(int i=2; i<n_house-1; i++) {
			money_1[i] = Math.max( money_1[i-1], money_1[i-2]+nums[i]);
		}

		// case 2: do not rob first house
		int[] money_2 = new int[n_house];
		money_2[0] = 0;
		money_2[1] = nums[1];
		for(int i=2; i<n_house; i++) {
			money_2[i] = Math.max( money_2[i-1], money_2[i-2]+nums[i]);
		}
		return Math.max(money_1[n_house-2], money_2[n_house-1]);
    }
}
