import java.util.*;
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS solution, uses the in-degree of the graph

		// get the in-degree of all vertices
		// and the mapping
		int[] in_deg = new int[numCourses];
		Map<Integer, HashSet<Integer>> map =
			new HashMap<Integer,HashSet<Integer>>();
		
		for(int i=0; i<prerequisites.length; i++){

			if(map.containsKey(prerequisites[i][1])){
				if(map.get(prerequisites[i][1])
				   .contains(prerequisites[i][0])){
					continue;
				}
			}
			in_deg[prerequisites[i][0]] ++;


			if(map.containsKey(prerequisites[i][1])){
				map.get(prerequisites[i][1])
					.add(prerequisites[i][0]);
			} else {
				HashSet<Integer> tmp = new HashSet<Integer>();
				tmp.add(prerequisites[i][0]);
				map.put(prerequisites[i][1], tmp);
			}
		}

		System.out.println(Arrays.toString(in_deg));

		// BFS to find if there is any loop in the graph
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<numCourses; i++){
			if(in_deg[i]==0){
				queue.add(i);
			}
		}

		int num_node=0;
		while(!queue.isEmpty()){
			int node = queue.poll();
			num_node ++;

			if(map.containsKey(node)){
				HashSet<Integer> node_children = map.get(node);
				for(int i:node_children) {
					in_deg[i]--;
					if(in_deg[i]==0){
						queue.add(i);
					}
				}
			}
		}

		if(num_node == numCourses){
			return true;
		}else{
			return false;
		}
    }
}
