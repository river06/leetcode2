/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
 // this method destroys the original graph, but works

import java.util.*;

public class Solution3 {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // use a queue to traverse the graph
        // use a hashmap to store the links between original and cloned nodes
        
        if(node == null) return null;
        
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> linkMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        // initialization
        queue.add(node);
        UndirectedGraphNode result = new UndirectedGraphNode( node.label);
        linkMap.put(node, result);
        
        while( !queue.isEmpty()) {
            UndirectedGraphNode oriNode = queue.poll();
            List<UndirectedGraphNode> oriNeighborList = oriNode.neighbors;
            
            if(!oriNeighborList.isEmpty()) queue.addAll(oriNeighborList);
            
            UndirectedGraphNode newNode = linkMap.get(oriNode);
            
            while(!oriNeighborList.isEmpty()) {
                UndirectedGraphNode oriNeighbor = oriNeighborList.remove(0); 
				// removed first element of original neighbors
                if( linkMap.containsKey(oriNeighbor) ){
                    newNode.neighbors.add(linkMap.get(oriNeighbor));
                } else {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(oriNeighbor.label);
                    linkMap.put(oriNeighbor, newNeighbor);
                    newNode.neighbors.add(newNeighbor);
                }
            }
        }
        return result;
    }
}