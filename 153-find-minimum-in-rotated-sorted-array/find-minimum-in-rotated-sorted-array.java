class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1, ans = (int)1e9;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            // if the array is already sorted 
            // then always nums[low] will  be smaller in th array
            if(nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            // left sorted part
            if(nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]); // store the min from sorted part
                low = mid + 1; // elemenate the left sorted path
                // right sorted part
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1; // elemenate the right sorted part
            }
        }
        return ans;
    }
}