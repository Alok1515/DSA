class Solution {

    Integer[][] dp;

    private int solve(int i, int j, int m, int n) {

        // base case
        if(i == m-1 && j == n-1) return 1;

        if(i > m || j > n) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int right = solve(i, j+1, m, n);
        int down = solve(i+1, j, m, n);

        return dp[i][j] = right + down; // total no. of ways
    }
    public int uniquePaths(int m, int n) {

        dp = new Integer[m+1][n+1];
        
        return solve(0, 0, m, n);
    }
}