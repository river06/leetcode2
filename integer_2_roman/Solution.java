public class Solution {
    public String intToRoman(int num) {
        int[] rnum = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] rtoken = {"M","CM","D","CD","C","XC","L",
						   "XL","X","IX","V","IV","I"};
		String ret = new String();
		for(int i=0; i<rnum.length; i++) {
			if(num>=rnum[i]) {
				int count = num/rnum[i];
				for(int j=0; j<count; j++) {
					ret += rtoken[i];
				}
				num -= count*rnum[i];
			}
		}
		return ret;
    }
}
