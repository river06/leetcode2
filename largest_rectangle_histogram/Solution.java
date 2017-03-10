import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] heights) {
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
