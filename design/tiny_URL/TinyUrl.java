public class TinyUrl {

	// increment index
	public static int ID = 0;
	// Map from id to long url
	private Map<Integer, String> id2Url = new HashMap<Integer, String>();
	// Map from long url to Id
	private Map<String, Integer> url2Id = new HashMap<String, Integer>();
	
    /**
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
		if (url2Id.containsKey(url)) {
			return "http://tiny.url/" + id2ShortKey(url2Id.get(url));
		}
		ID++;
		url2Id.put(url, ID);
		id2Url.put(ID, url);
		return "http://tiny.url/" + id2ShortKey(ID);
    }

    /**
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {
		String shortKey = url.substring("http://tiny.url/".length());
		int id = shortKey2Id(shortKey);
		return id2Url.get(id);
    }

	private int shortKey2Id(String shortKey) {
		int id = 0;
		for (int i = 0; i< shortKey.length(); i++) {
			id = id * 62 + toBase62(shortKey.charAt(i));
		}
		return id;
	}

	private String id2ShortKey(int id) {
		String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shortKey = "";
		while (id > 0) {
			shortKey = chars.charAt(id % 62) + shortKey;
			id /= 62;
		}
		while (shortKey.length() < 6) {
			shortKey = "0" + shortKey;
		}
		return shortKey;
	}

	private int toBase62(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        return c - 'A' + 36;
    }
}
