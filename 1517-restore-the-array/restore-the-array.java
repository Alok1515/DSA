class Solution {

    private int n;
    private final int MOD = (int)1e9 + 7;
    private Integer[] dp;

    private int solve(int start, String s, int k, Integer[] dp) {

        // base case
        if(start >= n) return 1; // one way

        if(s.charAt(start) == '0') return 0;

        long ans = 0;
        long num = 0;

        if(dp[start] != null) return dp[start];

        for(int end = start; end < n; end++) {

            num = (num * 10) + (s.charAt(end) -'0');

            if(num > k) break; // num out of range

            ans = ((ans % MOD) + solve(end + 1, s, k, dp) % MOD) % MOD;
        }

        return dp[start] = (int)ans;
    }

    public int numberOfArrays(String s, int k) {

        n = s.length();

        dp = new Integer[n];

        return solve(0, s, k, dp);
    }
}