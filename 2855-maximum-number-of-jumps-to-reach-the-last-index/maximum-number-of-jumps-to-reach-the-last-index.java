class Solution {

    public int maximumJumps(int[] nums, int target) {
        Integer[] dp = new Integer[nums.length + 1];

        int ans = solve(0, nums, target, dp);

        return ans < 0 ? -1 : ans;
    }

    private int solve(int i, int[] nums, int target, Integer[] dp) {

        // reached last index
        if(i == nums.length - 1) {
            return dp[i] = 0;
        }

        int result = -1;

        if(dp[i] != null) return dp[i];

        for(int j = i + 1; j < nums.length; j++) {

            if(Math.abs(nums[j] - nums[i]) <= target) {

                int temp = solve(j, nums, target, dp);

                if(temp != -1) {
                    result = Math.max(result, 1 + temp);
                }
            }
        }

        return dp[i] = result;
    }
}