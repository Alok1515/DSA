class Solution {
    private int m, n;
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        
        Integer[][][] dp = new Integer[m][n][k+1];
        int ans = helper(0, 0, 0, grid, k, dp);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    private int helper(int i, int j, int cost, int[][] grid, int k, Integer[][][] dp) {

        if(i >= m || j >= n) return Integer.MIN_VALUE;

        int newCost = cost + ((grid[i][j] == 1 || grid[i][j] == 2) ? 1 : 0);

        if(newCost > k) return Integer.MIN_VALUE;

        if(i == m-1 && j == n-1) return grid[i][j];

        if(dp[i][j][cost] != null) return dp[i][j][cost];

        int right = helper(i + 1, j, newCost, grid, k, dp);
        int down =  helper(i, j + 1, newCost, grid, k, dp);

        int maxNext = Math.max(right, down);
        
        if(maxNext == Integer.MIN_VALUE) return dp[i][j][cost] = Integer.MIN_VALUE;

        return dp[i][j][cost] =  grid[i][j] + maxNext;
    }
}