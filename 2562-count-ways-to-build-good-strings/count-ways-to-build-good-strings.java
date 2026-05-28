class Solution {

    int[] dp;
    private int MOD = (int)1e9 + 7;

    private int solve(int len, int low, int high, int zero, int one) {

        // Base case
        if(len > high) {
            return 0;
        }

        int count = 0;

        if(len >= low && len <= high) {
            count = 1;
        }

        if(dp[len] != -1) return dp[len];

        int takeOne = solve(len + one, low, high, zero, one);
        int takeZero = solve(len + zero, low, high, zero, one);

        return dp[len] = (count + takeOne + takeZero) % MOD;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {

        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        
        return solve(0, low, high, zero, one);
    }
}