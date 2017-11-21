import java.util.*;
class Solution {
	public Map<String, Integer> word2Count = new HashMap<String, Integer>();

	public Comparator<String> newComparator = new Comparator<String>() {
		public int compare(String a, String b) {
			return word2Count.get(a) ==  word2Count.get(b) ?
			b.compareTo(a) : word2Count.get(a) - word2Count.get(b);
		}
	};
	
	public List<String> topKFrequent(String[] words, int k) {
        // make into a set
		for (String word: words) {
			word2Count.put(word, word2Count.getOrDefault(word, 0)+1);
		}

		// get sorted list by heap
		PriorityQueue<String> heap = new PriorityQueue<String>(newComparator);

		for (String word: word2Count.keySet()) {
			heap.offer(word);
			if (heap.size() > k) {
				heap.poll();
			}
		}

		List<String> ret = new ArrayList<String>();
		while (!heap.isEmpty()) {
			ret.add(heap.poll());
		}
		Collections.reverse(ret);
		return ret;
    }

}
