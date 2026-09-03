import java.util.Arrays;

class Solution {
    public int uniqueLetterString(String s) {
        int[] last = new int[26];
        int[] prev = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(prev, -1);
        
        int res = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            if (last[c] != -1) {
                res += (last[c] - prev[c]) * (i - last[c]);
            }
            prev[c] = last[c];
            last[c] = i;
        }
        
        for (int c = 0; c < 26; c++) {
            if (last[c] != -1) {
                res += (last[c] - prev[c]) * (n - last[c]);
            }
        }
        
        return res;
    }
}