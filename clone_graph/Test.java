import java.util.*;

public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		node.neighbors.add( node );
		node.neighbors.add( node );
		UndirectedGraphNode ret = solver.cloneGraph(node);

		Queue<UndirectedGraphNode> queue =
			new LinkedList<UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> visited_set = new HashSet<UndirectedGraphNode>();
		
		queue.offer(ret);
		
		while( !queue.isEmpty() ) {
			UndirectedGraphNode n = queue.poll();
			if(visited_set.contains(n)) continue;
			System.out.print(n.label);
			System.out.print("|");
			for(UndirectedGraphNode nb:n.neighbors) {
				System.out.print(nb.label);
				System.out.print(",");
				if( !visited_set.contains(nb) ) {
					queue.offer(nb);
				}
			}
			System.out.println(" ");
			visited_set.add(n);
		}
	}
}