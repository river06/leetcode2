import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] paths = {"/home/", "/home", "//", "//.//../home",
						  "/a/./b/../../c/", "/a/b/../c"};

		for (String path: paths) {
			System.out.println(path);
			System.out.println(solver.simplifyPath(path));
			System.out.println("------------------");
		}
	}
}
