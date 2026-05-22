class Solution {

    int n;
    Integer[][] dp;

    private int solve(int i, int[] coins, int amount) {

        // base case
        if(i == n-1) {
            return (amount % coins[i] == 0) ? amount / coins[n-1] : (int)1e9;
        }

        if(dp[i][amount] != null) return dp[i][amount];

        int notTake = solve(i+1, coins, amount);
        int take = (int)1e9;

        if(coins[i] <= amount) {
            take = 1 + solve(i, coins, amount - coins[i]);
        }

        return dp[i][amount] = Math.min(notTake, take);
    }

    public int coinChange(int[] coins, int amount) {
        
        n = coins.length;
        dp = new Integer[n+1][amount+1];

        int ans = solve(0, coins, amount);

        return (ans >= 1e9) ? -1 : ans;
    }
}