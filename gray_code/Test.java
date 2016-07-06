import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
        int n = 0;
        List<Integer> ret = solver.grayCode(n);
        
        for( Integer int_tmp : ret) System.out.println(int_tmp);
	}
}
