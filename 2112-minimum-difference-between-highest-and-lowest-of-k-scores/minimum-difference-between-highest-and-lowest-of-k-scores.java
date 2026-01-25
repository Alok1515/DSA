class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        if(n == 1) return 0;

        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = k - 1;

        while(j < n) {
            minDiff = Math.min(minDiff, nums[j] - nums[i]);
            i++;
            j++;
        }

        return minDiff;
    }
}