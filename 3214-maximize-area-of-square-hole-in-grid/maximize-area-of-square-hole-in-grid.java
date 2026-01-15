class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // 1st step : sort the inputs
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxConsecutiveHBars = 1; // length of longest h bars
        int maxConsecutiveVBars = 1;

        // First find the longest consecutive horizonatal bar
        int currConsecutiveHBars = 1;
        for(int i = 1; i < hBars.length; i++) {
            if(hBars[i] - hBars[i-1] == 1) {
                currConsecutiveHBars++;
            } else {
                currConsecutiveHBars = 1; // reset to one
            }
            maxConsecutiveHBars = Math.max(maxConsecutiveHBars, currConsecutiveHBars);
        }

        // similarly, find length of longest vertical bars
        int currConsecutiveVBars = 1;
        for(int i = 1; i < vBars.length; i++) {
            if(vBars[i] - vBars[i - 1] == 1) {
                currConsecutiveVBars++;
            } else {
                currConsecutiveVBars = 1; // reset to 1
            }
            maxConsecutiveVBars = Math.max(maxConsecutiveVBars, currConsecutiveVBars);
        }

        // square width height must be be same. we can reduce the larger one to match the smaller one so, take minimum of them.
        int side = Math.min(maxConsecutiveHBars, maxConsecutiveVBars) + 1;
        return side * side;
    }
}