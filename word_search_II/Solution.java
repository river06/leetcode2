import java.util.*;
class Solution {
	Set<String> ret = new HashSet<String>();
	Trie dict;
	int m;
	int n;
	int[][] dir = {{-1,0}, {1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        dict = new Trie();
		for (String word: words) {
			dict.insert(word);
		}
		m = board.length;
		n = board[0].length;
		
		// back tracking
		
		boolean[][] isVisited = new boolean[m][n];
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				sb.append(board[i][j]);
				isVisited[i][j] = true;
				bt(board, sb, isVisited, i, j);
				isVisited[i][j] = false;
				sb.deleteCharAt(sb.length()-1);
			}
		}

		return new ArrayList<String>(ret);
    }

	private void bt(char[][] board, StringBuilder sb, boolean[][] isVisited,
					int x, int y) {
		int isWord = dict.search(sb.toString());
		if (isWord == -1) {
			return;
		} else if (isWord == 1) {
			ret.add(sb.toString());
		}
		
		for (int[] d: dir) {
			int nx = x + d[0];
			int ny = y + d[1];
			
			if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isVisited[nx][ny]) {
				sb.append(board[nx][ny]);
				isVisited[nx][ny] = true;
				bt(board, sb, isVisited, nx, ny);
				isVisited[nx][ny] = false;
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}

	class TrieNode {
		TrieNode[] children;
		boolean isWord;

		TrieNode () {
			this.children = new TrieNode[26];
			this.isWord = false;
		}
	}

	class Trie {
		TrieNode root = new TrieNode();

		int search (String word) {
			TrieNode p = this.root;

			for (int i=0; i<word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (p.children[idx] == null) {
					return -1;
				}
				p = p.children[idx];
			}

			return p.isWord ? 1 : 0;
		}
		
		void insert (String word) {
			TrieNode p = this.root;

			for (int i=0; i<word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (p.children[idx] == null) {
					p.children[idx] = new TrieNode();
				}
				p = p.children[idx];
			}

			p.isWord = true;
		}
	}
}
