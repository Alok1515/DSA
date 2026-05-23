class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] == target) return true;

             // duplicate check
            if(nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
                continue; // skip further part
            }


            // left sorted half
            if(nums[l] <= nums[mid]) {

                // check if it is in left side
                if(nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // right sorted half
                if(nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return false;
    }
}