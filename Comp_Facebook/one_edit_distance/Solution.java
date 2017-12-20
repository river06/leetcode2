class Solution {
    public boolean isOneEditDistance(String s, String t) {
		if(Math.abs(s.length()-t.length()) > 1) return false;
		if(s.length() == t.length()) return isOneModify(s,t);
		if(s.length() > t.length()) return isOneDel(s,t);
		return isOneDel(t,s);
	}
	public boolean isOneDel(String s,String t){
		for(int i=0,j=0;i<s.length() && j<t.length();i++,j++){
			if(s.charAt(i) != t.charAt(j)){
				return s.substring(i+1).equals(t.substring(j));
			}
		}
		return true;
	}
	public boolean isOneModify(String s,String t){
		int diff =0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) != t.charAt(i)) {
				diff++;
				if (diff > 1) {
					return false;
				}
			}
		}
		return diff==1;
	}
}
