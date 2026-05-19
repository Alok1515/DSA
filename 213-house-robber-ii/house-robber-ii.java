class Solution {

    Integer[] dp;

    private int solve(int i, int end, int[] nums) {

        if(i > end) return 0;

        if(dp[i] != null) return dp[i];

        int pick = nums[i] + solve(i + 2, end, nums);
        int notPick = solve(i + 1, end, nums);

        return dp[i] = Math.max(pick, notPick);
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];

        // Case 1: 0 -> n-2
        dp = new Integer[n];
        int option1 = solve(0, n - 2, nums);

        // Case 2: 1 -> n-1
        dp = new Integer[n];
        int option2 = solve(1, n - 1, nums);

        return Math.max(option1, option2);
    }
}