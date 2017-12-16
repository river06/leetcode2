import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] ss = {"b", "bcb", "bb", "bccb",	"bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbdaada"};
		for (String s: ss) {
			int ret = solver.countPalindromicSubsequences(s);
			System.out.println(s + ": " + ret);
		}
	}
}
