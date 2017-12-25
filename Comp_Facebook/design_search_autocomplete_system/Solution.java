import java.util.*;
class AutocompleteSystem {
	Trie dict;
	StringBuilder curSentence;
	Map<String, Integer> sentence2Freq;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.dict = new Trie();
		this.curSentence = new StringBuilder();
		this.sentence2Freq = new HashMap<String, Integer>();

		// insert sentences
		for (int i=0; i<sentences.length; i++) {
			this.dict.insert(sentences[i], times[i]);
			this.sentence2Freq.put(sentences[i], times[i]);
		}
    }
    
    public List<String> input(char c) {
		List<String> ret = new ArrayList<String>();
		if (c != '#') {
			this.curSentence.append(c);
			ret = this.dict.searchNext(c);
		} else {
			String sentence = this.curSentence.toString();
			int freq = this.sentence2Freq.getOrDefault(sentence, 0) + 1;
			this.sentence2Freq.put(sentence, freq);
			this.dict.insert(sentence, freq);
			this.curSentence = new StringBuilder();
			this.dict.reset();
		}

		return ret;
    }
	
	class NumedString implements Comparable<NumedString> {
		int freq;
		String sentence;
		NumedString (String str, int freq) {
			this.sentence = str;
			this.freq = freq;
		}
		public int compareTo(NumedString newStr) {
			if (this.freq != newStr.freq) {
				return this.freq - newStr.freq;
			} else {
				String newSentence = newStr.sentence;
				int length = Math.min(this.sentence.length(), newSentence.length());
				for (int i=0; i<length; i++) {
					if (this.sentence.charAt(i) != newSentence.charAt(i)) {
						return newSentence.charAt(i) - this.sentence.charAt(i);
					}
				}
				return newSentence.length() - this.sentence.length();
			}
		}
	}
	
	class TrieNode {
		TrieNode[] children;
		Queue<NumedString> topSentence;
		boolean isWordEnd;
		TrieNode () {
			this.children = new TrieNode[27];
			this.topSentence = new PriorityQueue<NumedString>(); // min heap
			this.isWordEnd = false;
		}
	}

	class Trie {
		private TrieNode root;
		private TrieNode pc;
		boolean hasFailed;
		Trie () {
			this.root = new TrieNode();
			this.pc = this.root;
			this.hasFailed = false;
		}

		void reset() {
			this.pc = this.root;
			this.hasFailed = false;
		}

		List<String> searchNext (char c) {
			List<String> ret = new ArrayList<String>();
			if (!this.hasFailed) {
				int idx = getIdx(c);
				if (this.pc.children[idx] == null) {
					this.hasFailed = true;
					return ret;
				} else {
					this.pc = this.pc.children[idx];

					Queue<NumedString> newQ = new PriorityQueue<NumedString>();
					while (!this.pc.topSentence.isEmpty()) {
						NumedString top = this.pc.topSentence.poll();
						ret.add(0, top.sentence);
						newQ.add(top);
					}
					this.pc.topSentence = newQ;
				}
			}

			return ret;
		}

		void insert (String sentence, int freq) {

			NumedString sentenceAndFreq = new NumedString(sentence, freq);
			
			TrieNode cur = this.root;
			for (int i=0; i<sentence.length(); i++) {
				char c = sentence.charAt(i);
				int idx = getIdx(c);
				if (cur.children[idx] == null) {
					cur.children[idx] = new TrieNode();
				}
				updateQueue(cur.children[idx], sentenceAndFreq);
				cur = cur.children[idx];
			}
		}

		private void updateQueue(TrieNode cur, NumedString newSentence) {
			// check if sentence already exists
			Iterator<NumedString> iter = cur.topSentence.iterator();
			while (iter.hasNext()) {
				NumedString old = iter.next();
				if (old.sentence.equals(newSentence.sentence)) {
					cur.topSentence.remove(old);
					break;
				}
			}
			
			cur.topSentence.add(newSentence);
			if (cur.topSentence.size() > 3) {
				cur.topSentence.poll();
			}
		}

		private int getIdx(char c) {
			if (c >= 'a' && c <= 'z') {
				return c - 'a';
			} else {
				return 26;
			}
		}		
	}
}
