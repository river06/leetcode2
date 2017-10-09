/**
 * Definition of Column:
 * public class Column {
 *     public int key;
 *     public String value;
 *     public Column(int key, String value) {
 *         this.key = key;
 *         this.value = value;
 *    }
 * }
 */


public class MiniCassandra {

	private Map<String, NavigableMap<Integer, String>> grid;
	
    public MiniCassandra() {
		this.grid = new HashMap<String, NavigableMap<Integer, String>>();
    }

    /**
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String raw_key, int column_key, String column_value) {
		if (!grid.containsKey(raw_key)) {
			grid.put(raw_key, new TreeMap<Integer, String>());
		}
		grid.get(raw_key).put(column_key, column_value);
    }

    /**
     * @param raw_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
		List<Column> ret = new ArrayList<Column>();
		if (!grid.containsKey(raw_key)) { return ret; }
		for (Map.Entry<Integer, String> entry:
				 grid.get(raw_key).subMap
				 (column_start, true, column_end, true).entrySet()) {
			ret.add(new Column(entry.getKey(), entry.getValue()));
		}
		return ret;
    }
}
