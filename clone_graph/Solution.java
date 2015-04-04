
import java.util.*;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;

		//HashSet<UndirectedGraphNode> cloned_node = new HashSet<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode,UndirectedGraphNode> cloned_map =
			new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> visit_node = new LinkedList<UndirectedGraphNode>();

		UndirectedGraphNode ret = new UndirectedGraphNode( node.label);
		visit_node.offer(node);
		cloned_map.put(node, ret);
		

		while( !visit_node.isEmpty() ) {
			UndirectedGraphNode n = visit_node.poll();
			List<UndirectedGraphNode> neighbors = n.neighbors;
			for(UndirectedGraphNode nb : neighbors) {
				//	if( !cloned_node.contains(nb) ) {
					UndirectedGraphNode nb_cp;
					if( cloned_map.containsKey(nb) ){
						nb_cp = cloned_map.get(nb);
					} else {
						nb_cp = new UndirectedGraphNode(nb.label);
						cloned_map.put(nb, nb_cp);
					}
					UndirectedGraphNode n_cp = cloned_map.get(n);
					n_cp.neighbors.add(nb_cp);
					if( nb.label != n.label) visit_node.add(nb);
					//		}
			}
			//cloned_node.add(n);
		}
		return ret;
    }
}

