import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to keep track of the top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element in the heap
            }
        }

        return minHeap.peek(); // Top element is the kth largest
    }
}