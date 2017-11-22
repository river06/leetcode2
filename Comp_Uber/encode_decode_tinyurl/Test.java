import java.util.*;
public class Test {
	public static void main(String[] args) {
		Codec codec = new Codec();
		String url = "https://google.com";
		String sUrl = codec.encode(url);
		String lUrl = codec.decode(sUrl);

		System.out.println(sUrl);
		System.out.println(lUrl);

	    url = "https://google.com";
		sUrl = codec.encode(url);
		lUrl = codec.decode(sUrl);

		System.out.println(sUrl);
		System.out.println(lUrl);
		
	}
}
