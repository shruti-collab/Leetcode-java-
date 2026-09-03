import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Prices array to store the cheapest price to reach each city
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        // We can make at most k stops, which means k + 1 flights / edges
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];
                
                if (prices[u] != Integer.MAX_VALUE) {
                    temp[v] = Math.min(temp[v], prices[u] + price);
                }
            }
            
            prices = temp;
        }
        
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}