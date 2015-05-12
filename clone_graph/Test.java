import java.util.*;

public class Test {
	public static void main(String[] args) {
		//Solution solver = new Solution();
		Solution2 solver = new Solution2();
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		node0.neighbors.add( node1);
		node1.neighbors.add( node0 );
		UndirectedGraphNode ret = solver.cloneGraph(node0);

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