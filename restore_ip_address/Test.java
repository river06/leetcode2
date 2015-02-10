import java.util.*;

public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();

//		String s = "25525511135";
		String s = "0279245587303";

		ArrayList<String> ret = solver.restoreIpAddresses(s);

		for(int i=0; i<ret.size(); i++) {
			System.out.println( ret.get(i) );
		}
	}
}