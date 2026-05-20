class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        Integer[][] dp = new Integer[m+1][n+1];

        dp[m-1][n-1] = grid[m-1][n-1];

        for(int i = m-1; i >= 0; i--) {

            for(int j = n-1; j >= 0; j--) {

                // skip destination cell
                if(i == m - 1 && j == n - 1) {
                    continue;
                }

                int down  = (i+1) < m ? dp[i+1][j] : Integer.MAX_VALUE;
                int right = (j+1) < n ? dp[i][j+1] : Integer.MAX_VALUE;

                dp[i][j] = grid[i][j] + Math.min(down, right);
            }
        }

        return dp[0][0];
    }
}