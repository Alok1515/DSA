class Solution {

    int m, n;
    Integer[][] dp;

    private int solve(int i, int j, int[][] matrix) {

        if(j < 0 || j >= n) return Integer.MAX_VALUE;

        // base case
        if(i == m-1) return matrix[i][j];

        if(dp[i][j] != null) return dp[i][j];

        int down      = solve(i+1, j, matrix);
        int diagLeft  = solve(i + 1, j - 1, matrix);
        int diagRight = solve(i + 1, j + 1, matrix);

        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(diagLeft, diagRight));
    }
    public int minFallingPathSum(int[][] matrix) {
        
        m = matrix.length;
        n = matrix[0].length;

        dp = new Integer[m+1][n+1];

        int ans = Integer.MAX_VALUE;

        for(int j = 0; j < n; j++) {
            ans = Math.min(ans, solve(0, j, matrix));
        }

        return ans;
    }
}