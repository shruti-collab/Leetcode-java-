class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        // hold: max profit when holding a stock
        // free: max profit when not holding a stock
        int hold = -prices[0];
        int free = 0;
        
        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            
            // Either keep holding the previous stock or buy at prices[i]
            hold = Math.max(hold, free - prices[i]);
            
            // Either keep free status or sell the held stock at prices[i] minus fee
            free = Math.max(free, prevHold + prices[i] - fee);
        }
        
        return free;
    }
}