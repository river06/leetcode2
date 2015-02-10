import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		List<List<String>> ret = solver.findLadders(start, end, dict);
		for(int i=0; i<ret.size(); i++) {
			List<String> ladder = ret.get(i);
			for(int j=0; j<ladder.size(); j++) {
				System.out.print( ladder.get(j) );
				System.out.print( "->" );
			}
			System.out.println(" ");
		}
	}
}