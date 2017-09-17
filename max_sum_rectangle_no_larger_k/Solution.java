import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}

		int maxSum = Integer.MIN_VALUE;
		for (int i=0; i<matrix.length; i++) {
			int[] sums = new int[matrix[0].length];
			
			
			for (int j=i; j<matrix.length; j++) {
				int curSum = 0;
				
				for (int l = 0; l<matrix[0].length; l++) {
					// System.out.println("j: "+j+"l: "+l);
					sums[l] += matrix[j][l];
				}
				
				TreeSet<Integer> set = new TreeSet<Integer>();

				for (int l = 0; l < matrix[0].length; l++) {
					curSum += sums[l];
					if (curSum <=k) {
						maxSum = Math.max(maxSum, curSum);
					}
					// binary search for sum[sum] <= val - k
					Integer preSum = set.ceiling(curSum - k);
					if (preSum != null) {
						maxSum = Math.max(maxSum, curSum-preSum);
					}
					set.add( curSum );
				}
				
			}
		}

		return maxSum;
    }

	/*public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0 || cols == 0)
            return 0;
        int maxValue = Integer.MIN_VALUE;
         
        int length, width;
        if (rows >= cols) {
            length = rows;
            width = cols;
        } else {
            length = cols;
            width = rows;
        }
         
        for (int i = 0; i < width; i++) {
            int[] sums = new int[length];
            for (int j = i; j < width; j++) {
                int currSum = 0;
                TreeSet<Integer> preSum = new TreeSet<>();
                for (int z = 0; z < length; z++) {
                    sums[z] += length == cols ? matrix[j][z] : matrix[z][j];
                    currSum += sums[z];
                    if (currSum <= k) {
                        maxValue = Math.max(currSum, maxValue);
                    }
                    // when currSum is greater than k.
                    Integer dif = preSum.ceiling(currSum - k);
                    //remove previous sum to get a value that may be the max value.
                    if (dif != null) {
                        maxValue = Math.max(maxValue, currSum - dif);
                    }
                    preSum.add(currSum);
                }
            }
        }
        return maxValue;
             
    }*/
}
