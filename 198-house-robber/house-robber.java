class Solution {

    int n;
    Integer[] dp;

    private int solve(int i, int[] nums, int n) {

        // base case
        if(i == n-1) return nums[i];

        if(i >= n) return 0;

        if(dp[i] != null) return dp[i];

        int pick = nums[i] + solve(i + 2, nums, n);
        int notPick = 0 + solve(i + 1, nums, n);

        return dp[i] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        
        n = nums.length;

        dp = new Integer[n];

        return solve(0, nums, n);
    }
}