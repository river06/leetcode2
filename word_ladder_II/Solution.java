import java.util.*;
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		// push list to hashset
		Map<String, Integer> wordMap = new HashMap<String, Integer>(); // string to distance
		for(String str: wordList) { wordMap.put(str, 0); }
		wordMap.put( beginWord, 1 );

		List<List<String>> ladders = new LinkedList<List<String>>();
		Map<String, Set<String>> backMap = new HashMap<String, Set<String>>();
		
		int length = ladderLength(beginWord, endWord, wordMap, backMap);

		if( length == 0 ) { return ladders; }
		
		List<String> path = new ArrayList<String>();
        dfs(beginWord, endWord, backMap, ladders, path, wordMap);

		return ladders;
    }

	private void dfs(String beginWord, String curWord, Map<String, Set<String>> backMap,
					 List<List<String>> ladders, List<String> path, Map<String, Integer> wordMap) {

		path.add( curWord );

		if( curWord.equals( beginWord ) ) {
			Collections.reverse(path);
			ladders.add(new LinkedList<String>(path));
			Collections.reverse(path);
		} else {
			for( String nextWord: backMap.get( curWord ) ) {
				if( wordMap.get(curWord) == wordMap.get(nextWord)+1 ) {
					dfs(beginWord, nextWord, backMap, ladders, path, wordMap);
				}
			}
		}

		path.remove( path.size()-1 );
	}
	
	private int ladderLength(String beginWord, String endWord, Map<String, Integer> wordMap,
							 Map<String, Set<String>> backMap) {
        
		Queue<String> queue = new LinkedList<String>();
			
		queue.offer( beginWord );
		int length = 1;
		boolean isFound = false;
		while( !queue.isEmpty() ) {
			length++;
			int queueLength = queue.size();
			for( int i=0; i<queueLength; i++ ) {
				String midWord = queue.poll();
				for( String nextWord: nextWords(wordMap, midWord, length) ) {
					if( nextWord.equals( endWord ) ) {
						isFound = true;
					}
					queue.offer( nextWord );
					if( !backMap.containsKey(nextWord) ) {
						Set<String> wordSet = new HashSet<String>();
						wordSet.add(midWord);
						backMap.put( nextWord, wordSet );
					} else {
						backMap.get( nextWord ).add( midWord );
					}

				}
			}
			if( isFound ) { return length; }
		}
		return 0;
    }

	List<String> nextWords (Map<String, Integer> wordMap, String midWord, int length) {
		List<String> ret = new LinkedList<String>();
		for( int i=0; i<midWord.length(); i++ ) {
			StringBuilder change = new StringBuilder(midWord);
			for( char c='a'; c<='z'; c++ ) {
				change.setCharAt( i, c );
				String newStr = new String( change );
				if( wordMap.containsKey(newStr) ) {
					if( wordMap.get(newStr) == 0 || wordMap.get(newStr)==length ) {
						wordMap.put(newStr, length);
						ret.add( newStr );
					}

				}
			}
		}

		return ret;
	}
}
