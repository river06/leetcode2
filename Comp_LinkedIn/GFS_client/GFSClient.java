/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */


public class GFSClient extends BaseGFSClient {

	int chunkSize;
	Map<String, Integer> file2Size;
	
    /**
	 * @param chunkSize: An integer
	 */
	public GFSClient(int chunkSize) {
        this.chunkSize = chunkSize;
		this.file2Size = new HashMap<String, Integer>();
    }

    /**
     * @param filename: a file name
     * @return: conetent of the file given from GFS
     */
    public String read(String filename) {
        if (!file2Size.containsKey(filename)) {
			return null;
		}

		String ret = new String();
		for (int i=0; i<file2Size.get(filename); i++) {
			ret += readChunk(filename, i);
		}
		return ret;
    }

    /**
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        if (filename == null || filename.length() == 0 ||
			content == null || content.length() == 0) {
			return;
		}
		int len = conetent.length();
		int nChunck = (len + this.chunkSize - 1) / this.chunkSize;
		for (int i=0; i<nChunck; i++) {
			int l = i*this.chunckSize;
			int r = Math.min( (i+1)*this.chunkSize, conetent.length());
			writeChunk(filename, i, content.substring(l, r));
		}
		file2Size.put(filename, nChunck);
    }
}
