import java.util.*;
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] heights = new int[m][n];

		// get heights
		for(int i=0; i<m; i++) {
			for( int j=0; j<n; j++) {
				if(matrix[i][j]=='0') {
					heights[i][j] = 0;
				} else {
					heights[i][j] = i==0 ? 1 : heights[i-1][j]+1;
				}
			}
		}

		int ret = Integer.MIN_VALUE;
		for( int i=0; i<m; i++){
			ret = Math.max(ret, largestRectangleArea(heights[i]) );
		}

		return ret;
    }


	private int largestRectangleArea(int[] heights) {
        if( heights==null || heights.length==0 ) { return 0; }

		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		int[] area = new int[heights.length];

		for(int i=0; i<heights.length; i++) {
			while( !stack.isEmpty() ) {
				if( heights[stack.peek()] >= heights[i] ) {
					stack.pop();
				} else {
					break;
				}
			}
			if( stack.isEmpty() ) {
				area[i] += heights[i]*(i+1);
			} else {
				area[i] += heights[i]*(i-stack.peek());
			}
			stack.push(i);
		}

		stack = new ArrayDeque<Integer>();

		for(int i=heights.length-1; i>=0; i--) {
			while( !stack.isEmpty() ) {
				if( heights[stack.peek()] >= heights[i] ) {
					stack.pop();
				} else {
					break;
				}
			}
			if( stack.isEmpty() ) {
				area[i] += heights[i]*(heights.length-i);
			} else {
				area[i] += heights[i]*(stack.peek()-i);
			}
			stack.push(i);
		}

		int ret = Integer.MIN_VALUE;
		for( int i=0; i<area.length; i++) {
			ret = ret > area[i]-heights[i] ? ret : area[i]-heights[i];
		}

		return ret;
    }
}
