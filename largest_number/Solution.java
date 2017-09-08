import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
        // radix sort might not work since there is no limitation on
		// the maximum number we will get
		String[] arr = new String[nums.length];
		for(int i=0; i<nums.length; i++){
			arr[i]=String.valueOf(nums[i]);
		}
	
		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String a, String b) {
				return (b+a).compareTo(a+b);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String s: arr) {
			sb.append(s);
		}

		while (sb.charAt(0)=='0' && sb.length()>1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
    }
}
