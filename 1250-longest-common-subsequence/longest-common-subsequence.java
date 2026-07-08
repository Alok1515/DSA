class Solution {
    int m, n;

    private int solve(String text1, String text2, int[][] dp) {

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }       
            }
        }
        return dp[m][n];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        m = text1.length();
        n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int[] row : dp) {
            Arrays.fill(row, 0);
        }
        
        return solve(text1, text2, dp);
    }
}