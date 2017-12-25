import java.util.*;
class WordFilter {
	Trie dict;
    public WordFilter(String[] words) {
		this.dict = new Trie();
        for (int i=0; i<words.length; i++) {
			this.dict.insert(words[i], i);
		}
    }
    
    public int f(String prefix, String suffix) {
        Queue<WeightedString> weightedWords = this.dict.search(prefix);

		int lSuffix = suffix.length();
		
		int weight = -1;
		Queue<WeightedString> removed = new LinkedList<WeightedString>();
		while (!weightedWords.isEmpty()) {
			WeightedString curWord = weightedWords.poll();
			removed.add(curWord);
			String str = curWord.value;
			if (str.substring(str.length()-lSuffix).equals(suffix)) {
				weight = curWord.weight;
				break;
			}
		}
		weightedWords.addAll(removed);

		return weight;
    }

	class WeightedString implements Comparable<WeightedString> {
		String value;
		int weight;
		WeightedString(String value, int weight) {
			this.value = value;
			this.weight = weight;
		}
		public int compareTo(WeightedString newStr) {
			return newStr.weight - this.weight;
		}
	}
	
	class TrieNode {
		TrieNode[] children;
		Queue<WeightedString> words;
		TrieNode () {
			this.children = new TrieNode[26];
			this.words = new PriorityQueue<WeightedString>();
		}
	}

	class Trie {
		TrieNode root;

		Trie () {
			this.root = new TrieNode();
		}

		Queue<WeightedString> search (String prefix) {
			if (prefix.length() == 0) {
				return this.root.words;
			}
			
			Queue<WeightedString> ret = new PriorityQueue<WeightedString>();
			TrieNode p = this.root;
			for (int i=0; i<prefix.length(); i++) {
				int idx = prefix.charAt(i) - 'a';

				if (p.children[idx] == null) {
					return ret;
				}

				p = p.children[idx];
			}

			return p.words;
		}

		void insert (String word, int weight) {
			TrieNode p = this.root;

			WeightedString weightedWord = new WeightedString(word, weight);

			p.words.add(weightedWord);
			
			for (int i=0; i<word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (p.children[idx] == null) {
					p.children[idx] = new TrieNode();
				}
				p = p.children[idx];

				p.words.add(weightedWord);
			}
		}
	}
}
