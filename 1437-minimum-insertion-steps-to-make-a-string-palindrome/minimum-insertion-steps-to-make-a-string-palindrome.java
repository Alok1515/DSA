class Solution {

    int n;
    Integer[][] dp;

    private int solve(int i, int j, String s) {

        // Base case
        if(i >= j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == (s.charAt(j))) {
            return dp[i][j] = solve(i+1, j-1, s);
        } 

        return dp[i][j] = 1 + Math.min(solve(i+1, j, s), solve(i, j-1, s));
    }

    public int minInsertions(String s) {

        n = s.length();
        
        dp = new Integer[n][n];

        return solve(0, n-1, s);
    }
}