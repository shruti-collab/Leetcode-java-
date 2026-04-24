
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        for(int i=0;i<s.length(); i=i+1){
            Set<Character> set =  new HashSet<>();


            for (int j=i; j<s.length(); j=j+1){
                char c = s.charAt(j);

                if (set.contains(c)) {
                    break;
                }
                set.add(c);
                max=Math.max(max, j-i+1);

            
            }
        }
        
        return max;
    }
}


