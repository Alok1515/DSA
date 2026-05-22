class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int j = 0; j < n; j++) {
            dp[m-1][j] = matrix[m-1][j];
        }

        for(int i = m-2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {

                int down =  dp[i+1][j];
                int diagLeft = (j-1 >= 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;
                int diagRight = (j+1 < n) ? dp[i+1][j+1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(diagLeft, diagRight));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;
    }
}