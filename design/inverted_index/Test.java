import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		List<Document> docs = new ArrayList<Document>();
		String[] contents = {
			"This is the content of document 1 it is very short",
			"This is the content of document 2 it is very long bilabial bilabial heheh hahaha ..."};

		for (int i=0; i<contents.length; i++) {
			docs.add( new Document(i, contents[i]));
		}

		Map<String, List<Integer>> map = solver.invertedIndex(docs);

		for (Map.Entry<String, List<Integer>> entry: map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
