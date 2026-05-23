class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            // we used (i+1) % n because if reach at the last element there
            // would be no element to compare with so by taking modulao
            // we are comparing nums[n] with nums[0]
            if(nums[i] > nums[(i + 1) % n]) count++;
        }
        if(count > 1) return false;
        return true;
    }
}