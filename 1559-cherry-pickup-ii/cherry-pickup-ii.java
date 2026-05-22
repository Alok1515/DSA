class Solution {
    int m, n;
    Integer[][][] dp;
    
    private int solve(int i, int j1, int j2, int[][] grid) {
        
        // out of bound case
        if(j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return Integer.MIN_VALUE;
        }

        // Base case
        if(i == m-1) {
            return (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != null) return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;

        // all 9 moves

        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {

                int value;

                if(j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }

                value += solve(i + 1, j1 + dj1, j2 + dj2, grid);

                maxi = Math.max(maxi, value);
            }
        }

        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m+1][n+1][n+1];

        return solve(0, 0, n-1, grid);
    }
}