import java.util.*;
public class Solution {
    public int ladderLength(String beginWord, String endWord,
							List<String> wordList) {
        if( wordList==null || wordList.isEmpty() ) { return 0; }

		Queue<String> queue = new LinkedList<String>();
		HashSet<String> hash = new HashSet<String>();

		for(String word: wordList) {
			hash.add(word);
		}
			
		queue.offer( beginWord );
		int length = 1;
		while( !queue.isEmpty() ) {
			int queueLength = queue.size();
			for( int i=0; i<queueLength; i++ ) {
				String midWord = queue.poll();
				for( String word: nextWords(hash, midWord) ) {
					if( word.equals( endWord ) ) {
						return length+1;
					}
					queue.offer( word );
				}
			}
			length++;
		}

		return 0;
		
    }

	List<String> nextWords (HashSet<String> hash, String midWord) {
		List<String> ret = new LinkedList<String>();
		for( int i=0; i<midWord.length(); i++ ) {
			StringBuilder change = new StringBuilder(midWord);
			for( char c='a'; c<='z'; c++ ) {
				change.setCharAt( i, c );
				String newStr = new String( change );
				if( hash.remove( newStr )) {
					ret.add( newStr );
				}
			}
		}

		return ret;
	}
}
