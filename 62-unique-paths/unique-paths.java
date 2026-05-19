class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];

        // base case
        dp[m-1][n-1] = 1;


        for(int i = m-1; i >= 0; i--) {

            for(int j = n-1; j >= 0; j--) {

                // skip destination cell
                if(i == m - 1 && j == n - 1) continue;

                int right = (j+1 < n) ? dp[i][j+1] : 0;
                int down  = (i+1 < m) ? dp[i+1][j] : 0;

                dp[i][j] = right + down;
            }
        }

        return dp[0][0];
    }
}