/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {

	private int buffPtr = 0;
	private int buffCnt = 0;
	private char[] buff = new buff[4];

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;

		while (ptr < n) {
			if (buffPtr == 0) {
				buffCnt = read4(buff);
			}

			if (buffCnt == 0) { break; }

			while (ptr < n && buffPtr < buffCnt) {
				buf[ptr++] = buff[buffPtr++];
			}

			if (buffPtr >= buffCnt) { buffPtr = 0; }
		}

		return ptr;
    }
}
