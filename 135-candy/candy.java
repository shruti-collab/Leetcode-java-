class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies = n;

        int i = 1;

        while(i < n) {
            // flat slope
            if(ratings[i] == ratings[i-1]) {
                i++;
                continue;
            }

            // Increasing slope
            int peak = 0;
            while(i < n && ratings[i] > ratings[i-1]) {
                peak += 1;
                candies += peak;
                i++;
            }

            // Decreasing slope
            int down = 0;
            while(i < n && ratings[i] < ratings[i-1]) {
                down += 1;
                candies += down;
                i++;
            }

            candies -= Math.min(peak, down);
        }

        return candies;
    }
} 