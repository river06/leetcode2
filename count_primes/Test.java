import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		for(int n=1; n<=10; n++){
			int ret = solver.countPrimes(n);
			System.out.println(ret);
		}
 
	}
}
