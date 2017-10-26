import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new LinkedList<String>();
		if (words == null || words.length == 0) {
			return ret;
		}

		int l = 0;
		int r = 0;
		int lWords = 0;
		while (r < words.length) {
			if (lWords + words[r].length() + r-l > maxWidth) {
				int nSpace = maxWidth - lWords;
				int nWords = r - l;
				StringBuilder sb = new StringBuilder();
				sb.append(words[l]);
				if (nWords == 1) {
					// left align
					for (int i=0; i<nSpace; i++) { sb.append(" "); }
				} else {
					for (int i=1; i<nWords; i++) {
						int nS = nSpace / (nWords - 1);
						if ( i <= nSpace % (nWords - 1) ) {
							nS++;
						}
						for (int j=0; j<nS; j++) { sb.append(" "); }
						sb.append(words[l+i]);
					}
				}
				ret.add( sb.toString() );
				l = r;
				lWords = 0;
			} else {
				lWords += words[r].length();
				r++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=l; i<r; i++) {
			sb.append(words[i] + " ");
		}
		if (sb.length() > maxWidth) {
			sb.deleteCharAt(sb.length()-1);
		}
		int lsb = sb.length();
		for (int i=0; i<maxWidth - lsb; i++) {
			sb.append(" ");
		}
		ret.add(sb.toString());
		return ret;
				
    }
}
