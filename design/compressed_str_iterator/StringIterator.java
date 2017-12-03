class StringIterator {
	/* properties */
	char[] charArr;
	int idx;
	char c;
	int count;
	
    public StringIterator(String compressedString) {
		if (compressedString == null || compressedString.length() == 0) {
			this.idx = -1;
		} else {
			this.charArr = compressedString.toCharArray();
			this.idx = 0;
			this.c = charArr[this.idx];
			this.count = this.getCount(this.idx+1);
		}
    }
    
    public char next() {
        if (!this.hasNext()) {
			System.out.println("space");
			return ' ';
		} else {
			char nextC = this.c;
			this.count--;
			if (this.count == 0) {
				this.idx++;
				while (this.idx < this.charArr.length &&
					   '0' <= charArr[this.idx] &&
					   charArr[this.idx] <= '9') {
					this.idx++;
				}
				if (this.hasNext()) {
					this.c = charArr[this.idx];
					this.count = this.getCount(this.idx+1);
				}
			}
			System.out.println(nextC);
			return nextC;
		}
    }

    public boolean hasNext() {
        if (this.idx < 0 || this.idx >= this.charArr.length) {
			return false;
		} else {
			return true;
		}
    }

	private int getCount(int idx) {
		int ret = 0;
		while (idx < charArr.length && '0' <= charArr[idx] && charArr[idx] <= '9') {
			ret *= 10;
			ret += charArr[idx] - '0';
			idx++;
		}
		return ret;
	}
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
