import java.util.*;
public class Test {
	public static void main(String[] args) {
		TinyUrl2 tinyUrl = new TinyUrl2();

		/*String url = tinyUrl.createCustom("http://www.lintcode.com/", "lccode");
		System.out.println(url);

		url = tinyUrl.createCustom("http://www.lintcode.com/", "lc");
		System.out.println(url);

		url = tinyUrl.longToShort("http://www.lintconde.com/problem/");
		System.out.println(url);

		url = tinyUrl.shortToLong("http://tiny.url/lccode");
		System.out.println(url);*/

		String url = tinyUrl.longToShort("http://www.lintcode.com/p7");
		System.out.println(url);
		url = tinyUrl.longToShort("http://www.lintcode.com/p8");
		System.out.println(url);
		url = tinyUrl.createCustom("http://www.lintcode.com/p1", "000001");
		System.out.println(url);
	}
}
