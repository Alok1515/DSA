class Solution {
    int m, n;
    Integer[][] dp;

    private int solve(int i, int j, String text1, String text2) {

        // out of bound case
        if(i >= m || j >= n) return 0;

        if(dp[i][j] != null) return dp[i][j];

        // base case 
        if(text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + solve(i + 1, j + 1, text1, text2);
        } else {
            return dp[i][j] = Math.max(solve(i + 1, j, text1, text2), solve(i, j + 1, text1, text2));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        m = text1.length();
        n = text2.length();
        dp = new Integer[m][n];
        
        return solve(0, 0, text1, text2);
    }
}