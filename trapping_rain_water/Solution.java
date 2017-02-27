import java.util.*;
public class Solution {
    public int trap(int[] height) {
    	int ret = 0;

        if(height.length<=2) { return ret; }

        Stack<Integer> decreasingHeights = new Stack<Integer>();
        Stack<Integer> decreasingPos = new Stack<Integer>();

        for( int i=0; i<height.length; i++ ) {

        	int rightHeight = height[i];
        	if( decreasingHeights.isEmpty() ) {
        		decreasingHeights.push( rightHeight );
        		decreasingPos.push( i );
        	} else {
        		int preHeight = 0;
        		while( !decreasingHeights.isEmpty() ) {
        			if( decreasingHeights.peek() <= rightHeight ) {
        				int leftHeight = decreasingHeights.pop();
        				int leftPos = decreasingPos.pop();
        				ret += (i-leftPos-1)*(leftHeight - preHeight);
        				preHeight = leftHeight;
        			} else {
        				int leftPos = decreasingPos.peek();
        				ret += (i-leftPos-1)*(rightHeight - preHeight);
        				decreasingHeights.push( rightHeight );
        				decreasingPos.push( i );
        				break;
        			}
        		}

        		if( decreasingHeights.isEmpty() ) {
        			decreasingHeights.push( rightHeight );
        			decreasingPos.push(i);
        		}
        	}
        }
        return ret;
    }
}