import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<String>();
		if (words == null || words.length == 0) { return ret; }

		int l = 0;
		while (l < words.length) {
			// process the first word
			StringBuilder sb = new StringBuilder();
			sb.append(words[l]);
			int sumStrLen = words[l].length(); // sum of length of strings
			int r = l + 1;
			while ( r < words.length ) {
				if (sumStrLen + words[r].length() + (r-l) > maxWidth) {
					break;
				} 
				sumStrLen += words[r].length();
				r++;
			}

			// three cases
			if (r == words.length || r == l+1) {
				// left align
				for (int i=l+1; i<r; i++) {
					sb.append( " " + words[i] );
				}
				while (sb.length() < maxWidth) {
					sb.append(" ");
				}
			} else {
				// justified
				int nWhite = (maxWidth - sumStrLen) / (r - l -1);
				for (int i=l+1; i<r; i++) {
					if ((maxWidth-sumStrLen) % (r-l-1) >= i-l) {
						sb.append(" ");
					}
					for (int k=0; k<nWhite; k++) { sb.append(" "); }
					sb.append( words[i] );
				}
			}

			ret.add(sb.toString());
			l = r;
		}

		return ret;
    }
}
