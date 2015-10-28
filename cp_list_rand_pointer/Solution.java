/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
import java.util.*;
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
		// computatoinal complexity: O(n)
		if(head==null) return null;
		HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode pH = head;
		RandomListNode ret = new RandomListNode(0);
		RandomListNode pN = ret;
		while(pH!=null){
			// create new node
			if(map.containsKey(pH)){
				pN.next = map.get(pH);
			}else{
				pN.next = new RandomListNode(pH.label);
				// put node in hashmap
				map.put(pH,pN.next);
			}
			
			

			// random node
			if(pH.random==null){
				pN.next.random = null;
			}else if(map.containsKey(pH.random)) {
				pN.next.random = map.get(pH.random);
			}else{
				pN.next.random = new RandomListNode(pH.random.label);
				map.put(pH.random, pN.next.random);
			}
			pH = pH.next;
			pN = pN.next;
		}
		return ret.next;
	}
}
