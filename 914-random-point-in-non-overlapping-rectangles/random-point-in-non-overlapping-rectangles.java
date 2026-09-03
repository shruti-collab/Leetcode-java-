import java.util.Random;
import java.util.TreeMap;

class Solution {
    private int[][] rects;
    private TreeMap<Integer, Integer> map;
    private int totalPoints;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.map = new TreeMap<>();
        this.rand = new Random();
        this.totalPoints = 0;

        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            // Number of integer points = (width + 1) * (height + 1)
            int points = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            totalPoints += points;
            map.put(totalPoints, i);
        }
    }
    
    public int[] pick() {
        int target = rand.nextInt(totalPoints) + 1;
        int rectIndex = map.ceilingEntry(target).getValue();
        
        int[] r = rects[rectIndex];
        int width = r[2] - r[0] + 1;
        int height = r[3] - r[1] + 1;
        
        int x = r[0] + rand.nextInt(width);
        int y = r[1] + rand.nextInt(height);
        
        return new int[] { x, y };
    }
}