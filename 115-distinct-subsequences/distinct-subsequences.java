class Solution {

    int m, n;
    Integer[][] dp;

    private int solve(int i, int j, String s, String t) {

        // base case
        if(j == n) return 1;
        if(i == m) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) {

            return dp[i][j] = solve(i+1, j+1, s, t) + solve(i+1, j, s, t);
        } else {
            return dp[i][j] = solve(i+1, j, s, t);
        }
    }
    public int numDistinct(String s, String t) {

        m = s.length();
        n = t.length();

        dp = new Integer[m+1][n+1];

        return solve(0, 0, s, t);
    }
}