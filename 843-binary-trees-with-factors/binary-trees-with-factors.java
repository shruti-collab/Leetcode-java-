import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = 1000000007;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        
        for (int x : arr) {
            dp.put(x, 1L);
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (dp.containsKey(right)) {
                        dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(right)) % MOD);
                    }
                }
            }
        }
        
        long ans = 0;
        for (long count : dp.values()) {
            ans = (ans + count) % MOD;
        }
        
        return (int) ans;
    }
}