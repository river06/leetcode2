public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String path = "/home/";
		// path = "/a/./b/../../c/";
		// path = "/../";
		// path = "/home//foo/";
		String ret = solver.simplifyPath(path);
		System.out.println(ret);
	}
}