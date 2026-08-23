class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];

        int[] leftPref = new int[n];
        int[] rightPref = new int[n];

        leftPref[0] = 1;

        for(int i = 1; i < n; i++) {
            leftPref[i] = leftPref[i-1] * nums[i-1];
        }

        rightPref[n-1] = 1;

        for(int i = n-2; i >= 0; i--) {
            rightPref[i] = rightPref[i+1] * nums[i+1];
        }

        for(int i = 0; i < n; i++) {
            result[i] = leftPref[i] * rightPref[i];
        }

        return result;
    }
}