class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length-1);
		int l = 0;
		int r = 0;
		while (r < str.length) {
			// find the word
			while (r < str.length) {
				if (str[r] == ' ') {
					reverse(str, l, r-1);
					l = r+1;
					r++;
					break;
				} else if (r == str.length-1) {
					reverse(str, l, r);
					r++;
					break;
				}
				r++;
			}
		}
    }

	private void reverse(char[] str, int l, int r) {
		while (l < r) {
			char tmp = str[l];
			str[l] = str[r];
			str[r] = tmp;
			l++;
			r--;
		}
	}
}
