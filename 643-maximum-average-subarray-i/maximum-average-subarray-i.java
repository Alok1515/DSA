class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int i = 0;
        int j = 0;

        double sum = 0;
        double maxSum = Double.NEGATIVE_INFINITY;

        while (j < nums.length) {

            sum += nums[j];

            int len = j - i + 1;

            if (len == k) {

                maxSum = Math.max(maxSum, sum);

                // Remove the leftmost element
                sum -= nums[i];

                i++;
            }

            j++;
        }

        return maxSum / k;
    }
}