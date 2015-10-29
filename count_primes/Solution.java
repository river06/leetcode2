import java.util.*;
public class Solution {
    public int countPrimes(int n) {
        boolean[] is_prime = new boolean[n];
		Arrays.fill(is_prime, true);

		for(int i=0; i*i<n; i++) {
			if(i<=1){
				is_prime[i]=false;
			}else if(is_prime[i]){
				is_prime = markNonPrime(is_prime, i, n);
			}
		}
		int n_prime = 0;
		for(int i=0; i<n; i++){
			if(is_prime[i]) n_prime++;
		}
		return n_prime;
    }
	boolean[] markNonPrime(boolean[] is_prime, int i, int n){
		for(int j=i*i; j<n; j+=i){
			is_prime[j]=false;
		}
		return is_prime;
	}
}
