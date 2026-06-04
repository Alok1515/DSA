class Solution {
    public int minimumAverageDifference(int[] nums) {

        int n = nums.length;

        long[] prefix = new long[n];

        prefix[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long minDiff = Long.MAX_VALUE;
        int ans = 0;

        for(int i = 0; i < n; i++) {

            long leftAvg = prefix[i] / (i + 1);

            long rightAvg = 0;

            if(i != n - 1) {
                rightAvg = (prefix[n - 1] - prefix[i]) / (n - i - 1);
            }

            long diff = Math.abs(leftAvg - rightAvg);

            if(diff < minDiff) {
                minDiff = diff;
                ans = i;
            }
        }

        return ans;
    }
}