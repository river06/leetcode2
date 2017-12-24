import java.util.*;
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // basically union find
		Map<String, String> email2Name = new HashMap<String, String>();
		UnionFind uf = new UnionFind();
		for (List<String> account: accounts) {
			String name = account.get(0);
			String mainEmail = account.get(1);
			if (!email2Name.containsKey(mainEmail)) {
				email2Name.put(mainEmail, name);
				uf.makeSet(mainEmail);
			}
			for (int i=2; i<account.size(); i++) {
				String otherEmail = account.get(i);
				if (!email2Name.containsKey(otherEmail)) {
					email2Name.put(otherEmail, name);
					uf.makeSet(otherEmail);
				}
				uf.union(mainEmail, otherEmail);
			}
		}

		// get the result
		Map<String, Set<String>> email2Emails = new HashMap<String, Set<String>>();
		for (String email: email2Name.keySet()) {
			String keyEmail = uf.find(email);
			if (!email2Emails.containsKey(keyEmail)) {
				email2Emails.put(keyEmail, new TreeSet<String>());
			}
			email2Emails.get(keyEmail).add(email);
		}

		List<List<String>> ret = new ArrayList<List<String>>();

		for (Map.Entry<String, Set<String>> entry: email2Emails.entrySet()) {
			List<String> account = new ArrayList<String>();
			String name = email2Name.get(entry.getKey());
			account.add(name);
			account.addAll(new ArrayList<String>(entry.getValue()));
			ret.add(account);
		}

		return ret;
    }

	class UnionFind {
		Map<String, String> email2Parent = new HashMap<String, String>();
		void makeSet (String str) {
			email2Parent.put(str, str);
		}

		String find (String str) {
			if (email2Parent.get(str).equals(str)) {
				return str;
			}

			email2Parent.put(str, find(email2Parent.get(str)));
			return email2Parent.get(str);
		}

		void union(String str1, String str2) {
			String r1 = find(str1);
			String r2 = find(str2);

			if (!r1.equals(r2)) {
				email2Parent.put(r2, r1);
			}
		}
	}
}
