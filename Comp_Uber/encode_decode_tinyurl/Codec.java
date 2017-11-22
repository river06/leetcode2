import java.util.*;

public class Codec {

	long id = 0;
	Map<Long, String> id2Long = new HashMap<Long, String>();
	int BASE = 62;
	String SURLHEADER = "http://tinyurl.com/";
	
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        this.id++;
		String shortUrl = getShortUrlFromID(this.id);
		id2Long.put(this.id, longUrl);
		return SURLHEADER + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
		if (shortUrl.length() < SURLHEADER.length()) {
			return "";
		}
		String code = shortUrl.substring(SURLHEADER.length());
        long shortId = getIDFromShortUrl(code);
		String longUrl = "";
		if (id2Long.containsKey(shortId)) {
			longUrl = id2Long.get(shortId);
		}
		return longUrl;
    }

	private long getIDFromShortUrl(String url) {
		long id = 0;
		for (int i=url.length()-1; i>=0; i--) {
			id *= BASE;
			id += charToBase62(url.charAt(i));
		}
		return id;
	}

	private String getShortUrlFromID(long id) {
		String url = "";
		while (id > 0) {
			url += charFromBase62(id % BASE);
			id /= BASE;
		}
		while (url.length() < 6) {
			url += "0";
		}
		return url;
	}

	private long charToBase62(char c) {
		long ret = 0;
		if ( '0' <= c && c <= '9') {
			ret = c - '0';
		} else if ('a' <= c && c <= 'z') {
			ret = c - 'a' + 10;
		} else {
			ret = c - 'A' + 36;
		}
		return ret;
	}

	private char charFromBase62(long id) {
		char c;
		if (0 <= id && id <= 9) {
			c = (char) (id + '0');
		} else if (10 <= id && id <= 35) {
			c = (char) (id - 10 + 'a');
		} else {
			c = (char) (id - 36 + 'A');
		}
		return c;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
