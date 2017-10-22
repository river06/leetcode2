import java.util.*;

class Solution {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
			return "Neither";
		}
		if (isIPv4(IP)) {
			return "IPv4";
		}
		if (isIPv6(IP)) {
			return "IPv6";
		}

		return "Neither";
    }

	private boolean isIPv4(String IP) {
		if (IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') {
			return false;
		}
		String[] duan = IP.split("\\.");
		if (duan.length != 4) { return false; }
		for (String str: duan) {
			if (!isIPv4Duan(str)) {
				return false;
			}
		}
		return true;
	}
	private boolean isIPv4Duan(String duan) {
		if (duan == null || duan.length() == 0) { return false; }
		if (duan.charAt(0) == '0' && duan.length() != 1) { return false; }
		int num = 0;
		for (int i=0; i<duan.length(); i++) {
			char c = duan.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			} else {
				num *= 10;
				num += c - '0';
				if (num > 255) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isIPv6(String IP) {
		if (IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':') {
			return false;
		}
		String[] duan = IP.split(":");
		if (duan.length != 8) { return false; }
		for (String str: duan) {
			if (!isIPv6Duan(str)) {
				return false;
			}
		}
		return true;
	}

	private boolean isIPv6Duan(String duan) {
		if (duan == null || duan.length() == 0 || duan.length() > 4) { return false; }
		for (int i=0; i<duan.length(); i++) {
			char c = duan.charAt(i);
			if (!( ('0'<=c && c<='9') || ('a' <= c && c<='f') || ('A'<=c && c<='F'))) {
				return false;
			}
		}
		return true;
	}
}
