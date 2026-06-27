class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            int majority = 0;

            for(int j = i; j < n; j++) {
                if(nums[j] == target) majority++;
                if(majority > (j-i+1) / 2) count++;
            }
        }

        return count;
    }
}