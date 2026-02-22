class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        int i = 0;
        int j = 0;

        int currSum = 0;
        int result = 0;
        int countZero = 0;

        while(j < n) {
            currSum += nums[j];

            // shrink the window 
            while(i < j && (nums[i] == 0 || currSum > goal)) {
                
                if(nums[i] == 0) {
                    countZero++;
                } else {
                    countZero = 0; // reset the value
                }
                currSum -= nums[i];
                i++;
            }

            if(currSum == goal) {
                result += 1 + countZero; 
            }

            j++;
        }
        
        return result;
    }
}