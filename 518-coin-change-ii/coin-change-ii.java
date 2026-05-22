class Solution {

    int n;
    Integer[][] dp;

    private int solve(int i, int[] coins, int amount) {

        // base case
        if(i == n-1) {
            return (amount % coins[i] == 0) ? 1 : 0;
        }

        if(dp[i][amount] != null) return dp[i][amount];

        int notTake = solve(i+1, coins, amount);
        int take = 0;

        if(coins[i] <= amount) {
            take = solve(i, coins, amount - coins[i]);
        }

        return dp[i][amount] = notTake + take;
    }

    public int change(int amount, int[] coins) {

        n = coins.length;

        dp = new Integer[n+1][amount+1];

        int ans = solve(0, coins, amount);

        return ans;
    }
}