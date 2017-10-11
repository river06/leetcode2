import java.util.*;

public class TinyUrl2 {

	// increment index
	public static int ID = 0;
	// Map from id to long url
	private Map<Integer, String> id2Url = new HashMap<Integer, String>();
	// Map from long url to Id
	private Map<String, Integer> url2Id = new HashMap<String, Integer>();
	// Map from custom long url to short url
	private Map<String, String> customLong2Short = new HashMap<String, String>();
	// Map from custom short url to long url
	private Map<String, String> customShort2Long = new HashMap<String, String>();

	/**
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    public String createCustom(String long_url, String key) {
        String short_url = "http://tiny.url/" + key;
        if (isNormalKey(key)) {
            int id = shortKey2Id(key);
            if (id2Url.containsKey(id) && !id2Url.get(id).equals(long_url)) {
                return "error";
            }

            if (url2Id.containsKey(long_url) && url2Id.get(long_url) != id) {
                return "error";
            }
            
            if (id2Url.containsKey(id) || url2Id.containsKey(long_url))
                return short_url;
        }
        
        if (customShort2Long.containsKey(short_url) && 
                !customShort2Long.get(short_url).equals(long_url)) {
            return "error";
        }
        
        if (customLong2Short.containsKey(long_url) && 
                !customLong2Short.get(long_url).equals(short_url)) {
            return "error";
        }
        
        customShort2Long.put(short_url, long_url);
		customLong2Short.put(long_url, short_url);
        return short_url;
    }
	
	/**
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
		if (customLong2Short.containsKey(url)) {
			return customLong2Short.get(url);
		}
		if (url2Id.containsKey(url)) {
			return "http://tiny.url/" + id2ShortKey(url2Id.get(url));
		}
		ID++;
		while (customShort2Long.containsKey("http://tiny.url/" + id2ShortKey(ID))) {
			ID++;
		}
		url2Id.put(url, ID);
		id2Url.put(ID, url);
		return "http://tiny.url/" + id2ShortKey(ID);
    }

    /**
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {
		if (customShort2Long.containsKey(url)) {
			return customShort2Long.get(url);
		}
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

	private boolean isNormalKey(String short_key) {
        if (short_key.length() != 6) {
            return false;
        }
        for (int i = 0; i < 6; i++) {
            char c = short_key.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                continue;
            }
            if (c >= 'A' && c <= 'Z') {
                continue;
            }
            return false;
        }
        return true;
    }
}
