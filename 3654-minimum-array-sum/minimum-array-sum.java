class Solution {
    private Integer dp[][][];

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        dp = new Integer[nums.length+1][op1 + 1][op2 + 1];
        return solve(nums, k, 0, op1, op2);
    }
    private int solve(int[] nums, int k, int i, int op1, int op2) {

        // base case
        if(i >= nums.length) return 0;

        int result = Integer.MAX_VALUE;

        if(dp[i][op1][op2] != null) return dp[i][op1][op2];

        // option 1
        if(op1 > 0) {
            int newVal = (nums[i] + 1) / 2;
            int applyOp1 = newVal + solve(nums, k, i+1, op1-1, op2);
            result = Math.min(result, applyOp1);
        }

        // option 2
        if(op2 > 0) {
            if(nums[i] >= k) {
                int newVal = nums[i] - k;
                int applyOp2 = newVal + solve(nums, k, i+1, op1, op2-1);
                result = Math.min(result, applyOp2);
            }
        }

        // option 3
        if(op1 > 0 && op2 > 0) {
            // apply op1 then apply op2
            int newVal = (nums[i] + 1) / 2;
            if(newVal >= k) {
                newVal = newVal - k;
                int applyOp1Op2 = newVal + solve(nums, k, i+1, op1-1, op2-1);
                result = Math.min(result, applyOp1Op2);
            }
        }

        // option 4
        if(op1 > 0 && op2 > 0) {
            // apply op2 then op1
            if(nums[i] >= k) {
                int newVal = nums[i] - k;
                newVal = (newVal + 1) / 2; 
                int applyOp2Op1 = newVal + solve(nums, k, i+1, op1-1, op2-1);
                result = Math.min(result, applyOp2Op1);
            }
        }

        // option 5
        // skip the index
        result = Math.min(result, nums[i] + solve(nums, k, i+1, op1, op2));

        return dp[i][op1][op2] = result;
    }
}