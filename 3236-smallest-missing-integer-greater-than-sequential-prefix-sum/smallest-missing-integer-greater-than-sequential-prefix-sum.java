class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        
        int sequential = nums[0];
        for (int j = 1; j < n; j++) {
            if (nums[j] == nums[j - 1] + 1) {
                sequential += nums[j];
            } else {
                break;
            }
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] == sequential) {
                sequential++;
            }
        }
        
        return sequential;
    }
}