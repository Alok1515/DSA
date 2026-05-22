class Solution {

    int n;
    Boolean[][] dp;

    private boolean solve(int i, int target, int[] nums) {

        // base case
        if(target == 0) return true;

        // out of bound check
        if(i == n) return false;

        if(dp[i][target] != null) return dp[i][target];

        boolean pick = false;

        if(nums[i] <= target) {
            pick = solve(i+1, target - nums[i], nums);
        }

        boolean notPick = solve(i+1, target, nums);

        return dp[i][target] = pick || notPick;
    }
    public boolean canPartition(int[] nums) {
        n = nums.length;

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // cant split into two partition
        if(sum % 2 != 0) return false;

        int target = sum / 2;
        dp = new Boolean[n+1][target+1];

        return solve(0, target, nums);
    }
}