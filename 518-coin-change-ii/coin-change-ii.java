class Solution {

    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n+1][amount+1];

        for(int a = 0; a <= amount; a++) {
            if(a % coins[0] == 0) {
                dp[0][a] = 1;
            } else {
                dp[0][a] = 0;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int a = 0; a <= amount; a++) {

                int notTake = dp[i-1][a];

                int take = 0;

                if(coins[i] <= a) {
                    take = dp[i][a - coins[i]];
                }

                dp[i][a] = notTake + take; 
            }
        }

        int ans = dp[n-1][amount];

        return ans;
    }
}