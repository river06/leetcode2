public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
		int p2 = numbers.length-1;
		while(p1<p2) {
			int num1 = numbers[p1];
			int num2 = numbers[p2];
			if( num1+num2==target ){
				int[] ret = new int[2];
				ret[0] = p1+1;
				ret[1] = p2+1;
				return ret;
			} 
			int mid = (p1+p2)/2;
			if (num1+num2 < target) {
				if( numbers[mid]+num2 < target ) {
					p1 = mid+1;
				} else {
					p1++;
				}
			} else {
				if( numbers[mid]+num1 > target ) {
					p2 = mid;
				} else {
					p2--;
				}
			}
		}
		
		return null;
    }
}