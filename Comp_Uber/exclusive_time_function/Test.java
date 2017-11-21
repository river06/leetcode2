import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int n = 3;
		/*String[] logsArr = {
			"0:start:0",
			"1:start:2",
			"1:end:5",
			"0:end:6"
			};*/
		String[] logsArr = {
			"0:start:0",
			"1:start:1",
			"2:start:2",
			"2:end:3",
			"1:end:4",
			"0:end:6",
			"1:start:7",
			"1:end:8",
		};
		List<String> logs = new ArrayList<String>();
		for (String log: logsArr) {
			logs.add(log);
		}
		int[] ret = solver.exclusiveTime(n, logs);
		System.out.println(Arrays.toString(ret));
		
	}
}
