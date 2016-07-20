import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		// int[] citations = {0,1,3,5,6}; 
		int[] citations = {2,2}; 
		System.out.println( solver.hIndex(citations) );
	}
}
