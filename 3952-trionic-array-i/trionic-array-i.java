class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 0;

        // 1) strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        // must have at least one increase
        if (i == 0) return false;

        // 2) strictly decreasing
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }

        // must have at least one decrease
        if (i == n - 1) return false;

        // 3) strictly increasing again
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        // must consume entire array
        return i == n - 1;
    }
}
