import java.util.*;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1_str = version1.split("\\.");
		String[] v2_str = version2.split("\\.");
		int v1_length = v1_str.length;
		int v2_length = v2_str.length;
		int max_length = Math.max(v1_length, v2_length);
		for(int i=0; i<max_length; i++) {
			int v1_num = (i<v1_length) ? Integer.parseInt(v1_str[i]):0;
			int v2_num = (i<v2_length) ? Integer.parseInt(v2_str[i]):0;
			if(v1_num > v2_num) {
				return 1;
			} else if (v1_num < v2_num) {
				return -1;
			}
		}
		return 0;
    }
}