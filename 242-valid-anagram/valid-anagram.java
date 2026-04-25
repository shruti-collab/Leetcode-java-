class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false ;
        int[] arr = new int[26] ; // freq arr

        for (int i = 0 ; i < s.length() ; i++ ){
            arr[s.charAt(i) - 'a']++ ; //both will cancel each other
            arr[t.charAt(i) - 'a']-- ; //out if they are anagrams
            
        }
        for (int i : arr){
            if (i != 0) {
                return false ;
            }
        }
        return true ;
    }
}