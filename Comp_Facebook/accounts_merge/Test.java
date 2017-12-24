import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*String[][] accounts = {
			{"John", "johnsmith@mail.com", "john00@mail.com"},
			{"John", "johnnybravo@mail.com"},
			{"John", "johnsmith@mail.com", "john_newyork@mail.com"},
			{"Mary", "mary@mail.com"}
		};*/
		String[][] accounts = {
			{"David","David0@m.co","David4@m.co","David3@m.co"},
			{"David","David5@m.co","David5@m.co","David0@m.co"},
			{"David","David1@m.co","David4@m.co","David0@m.co"},
			{"David","David0@m.co","David1@m.co","David3@m.co"},
			{"David","David4@m.co","David1@m.co","David3@m.co"}
		};

		List<List<String>> accountList = new ArrayList<List<String>>();

		for (String[] account: accounts) {
			accountList.add(Arrays.asList(account));
		}

		for (List<String> listAccount: accountList) {
			System.out.println(listAccount);
		}

		List<List<String>> mergedAccounts = solver.accountsMerge(accountList);

		System.out.println("----------- merged accounts: --------------");
		for (List<String> mergedAccount: mergedAccounts) {
			System.out.println(mergedAccount);
		}
	}
}
