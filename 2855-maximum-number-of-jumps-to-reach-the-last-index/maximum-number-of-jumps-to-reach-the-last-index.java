class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        int[] t = new int[n+1];

        Arrays.fill(t, Integer.MIN_VALUE);

        t[n-1] = 0;

        for(int i = n-2; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                if(Math.abs(nums[i] - nums[j]) <= target &&
                   t[j] != Integer.MIN_VALUE) {

                    int temp = 1 + t[j];

                    t[i] = Math.max(t[i], temp);
                }
            }
        }

        return t[0] < 0 ? -1 : t[0];
    }
}