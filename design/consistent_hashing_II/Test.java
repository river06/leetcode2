import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = Solution.create(100, 3);
		List<Integer> nodes = solver.addMachine(1);
		System.out.println(nodes);
		
		System.out.println(solver.getMachineIdByHashCode(4));

		nodes = solver.addMachine(2);
		System.out.println(nodes);

		System.out.println(solver.getMachineIdByHashCode(61));
		System.out.println(solver.getMachineIdByHashCode(91));
	}
}
