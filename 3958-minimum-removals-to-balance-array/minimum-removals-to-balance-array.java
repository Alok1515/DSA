class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int i = 0, j = 0;
        int max = nums[0], min = nums[0];

        int len = 1;

        while(j < n) {

            min = nums[i];
            max = nums[j];

            while(i < j && max > (long)min * k) {
                i++;
                min = nums[i];
            }
            len = Math.max(len, j-i+1);
            j++;
        }

        return n - len;
    }
}