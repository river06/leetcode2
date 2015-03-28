public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
		int[] n_candy = new int[ratings.length];
		int ret = 0;
		n_candy[0] = 1;
		for(int i=1; i<ratings.length; i++) {
			if(ratings[i] > ratings[i-1] ) {
				n_candy[i] = n_candy[i-1] + 1;
			} else {
				n_candy[i] = 1;
			}
		}
		for(int i=ratings.length-2; i>=0; i--) {
			if( ratings[i] > ratings[i+1] && n_candy[i] <= n_candy[i+1] ) {
				n_candy[i] =  n_candy[i+1]+1;
			}
			ret += n_candy[i];
		}
		return ret+n_candy[ ratings.length-1];	
    }
}