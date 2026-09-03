import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Queue<String>[] buckets = new Queue[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new LinkedList<>();
        }
        
        for (String word : words) {
            buckets[word.charAt(0) - 'a'].offer(word);
        }
        
        int count = 0;
        
        for (char c : s.toCharArray()) {
            Queue<String> q = buckets[c - 'a'];
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                
                if (word.length() == 1) {
                    count++;
                } else {
                    String nextWord = word.substring(1);
                    buckets[nextWord.charAt(0) - 'a'].offer(nextWord);
                }
            }
        }
        
        return count;
    }
}