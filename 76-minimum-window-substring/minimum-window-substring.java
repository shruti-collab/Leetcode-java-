class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        if(s.length() < t.length()) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char a : t.toCharArray()){
            map.merge(a,1,Integer::sum);
        }
        int i=0,j=0;
        int ans = Integer.MAX_VALUE;
        int count  = map.size();
        int start = i;
        while(j<s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    count--;
                }
            }
            while(count == 0){
                if(j-i+1 < ans){
                    ans = j-i+1;
                    start = i;
                }
                
                char left = s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left)>0) count++;
                }
                i++;
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(start,start+ans);
    }
}