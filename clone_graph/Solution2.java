
import java.util.*;

public class Solution2 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;

		//HashSet<UndirectedGraphNode> cloned_node = new HashSet<UndirectedGraphNode>();
		HashMap<Integer,UndirectedGraphNode> cloned_map =
			new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> visit_node = new LinkedList<UndirectedGraphNode>();

		UndirectedGraphNode ret = new UndirectedGraphNode( node.label);
		visit_node.offer(node);
		cloned_map.put(node.label, ret);
		

		while( !visit_node.isEmpty() ) {
			UndirectedGraphNode n = visit_node.poll();
			UndirectedGraphNode n_cp = cloned_map.get(n.label);
			for(UndirectedGraphNode nb : n.neighbors) {
					
				if( cloned_map.containsKey(nb.label) ){
					n_cp.neighbors.add(cloned_map.get(nb.label));
				} else {
					UndirectedGraphNode nb_cp = new UndirectedGraphNode(nb.label);
					cloned_map.put(nb.label, nb_cp);
					n_cp.neighbors.add(nb_cp);
				}
				
				visit_node.add(nb);
			}
			n.neighbors.clear(); // this is important for dealing with loops in the graph
		}
		return ret;
    }
}

