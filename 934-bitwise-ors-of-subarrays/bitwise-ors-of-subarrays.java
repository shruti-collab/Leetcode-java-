import java.util.HashSet;
import java.util.Set;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();

        for (int x : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(x);

            // Compute bitwise OR with all previous subarray results ending at i - 1
            for (int y : cur) {
                next.add(x | y);
            }

            // Update running sets
            cur = next;
            res.addAll(cur);
        }

        return res.size();
    }
}