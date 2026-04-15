class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSum = new long[nums.length + 1];
        TreeSet<Long> values = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        for (long sum : prefixSum) {
            values.add(sum);
            values.add(sum - lower);
            values.add(sum - upper);
        }
      
        Map<Long, Integer> compressedIndex = new HashMap<>();
        int rank = 1;
        for (long value : values) {
            compressedIndex.put(value, rank++);
        }
        
   
        FenwickTree bit = new FenwickTree(compressedIndex.size());
        int count = 0;
        
        for (long sum : prefixSum) {
            int left = compressedIndex.get(sum - upper);
            int right = compressedIndex.get(sum - lower);
            
            
            count += bit.rangeQuery(left, right);
            
            bit.update(compressedIndex.get(sum), 1);
        }
        
        return count;
    }
}

class FenwickTree {
    private int[] bit;
    
    public FenwickTree(int size) {
        bit = new int[size + 1]; 
    }
    
    public void update(int index, int delta) {
        while (index < bit.length) {
            bit[index] += delta;
            index += index & -index; 
        }
    }
    
    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & -index; 
        }
        return sum;
    }
    
    public int rangeQuery(int left, int right) {
        return query(right) - query(left - 1); 
    }
}