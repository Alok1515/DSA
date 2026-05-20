class Solution {

    int m, n;
    Integer[][] dp;

    private int solve(int i, int j, int[][] grid) {

        if(i >= m || j >= n) return Integer.MAX_VALUE;

        // base case
        if(i == m-1 && j == n-1) {
            return grid[i][j];
        }

        if(dp[i][j] != null) return dp[i][j];

        int down  =  solve(i+1, j, grid);
        int right =  solve(i, j+1, grid);

        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        
        m = grid.length;
        n = grid[0].length;

        dp = new Integer[m][n];

        return solve(0, 0, grid);
    }
}