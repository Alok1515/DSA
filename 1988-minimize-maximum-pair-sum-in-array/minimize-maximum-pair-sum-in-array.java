class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0, minSum = 0;

        int i = 0, j = n - 1;

        while(i < j) {
            sum = nums[i] + nums[j];
            minSum = Math.max(sum, minSum);
            i++;
            j--;
        }

        return minSum;
    }
}