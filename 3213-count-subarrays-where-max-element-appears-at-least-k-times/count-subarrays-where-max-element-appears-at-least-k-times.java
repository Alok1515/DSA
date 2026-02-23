class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;

        int i = 0, j = 0;
        long result = 0;
        int countMax = 0;
        int maxEle = 0;

        for(int max = 0; max < n; max++) {
            maxEle = Math.max(maxEle, nums[max]);
        }

        while(j < n) {
            if(nums[j] == maxEle) {
                countMax++;
            }

            while(countMax >= k) {
                result += n - j;

                if(nums[i] == maxEle) {
                    countMax--;
                }
                i++; // shrink the array
            }
            j++;
        }

        return result;
    }
}