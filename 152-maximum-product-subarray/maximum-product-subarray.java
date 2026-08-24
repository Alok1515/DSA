class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int pref   = 1;
        int suffix = 1;

        for(int i = 0; i < n; i++) {
            if(pref   == 0) pref = 1;
            if(suffix == 0) suffix = 1;

            pref   *= nums[i];
            suffix *= nums[n-i-1];

            maxProd = Math.max(maxProd, Math.max(pref, suffix));
        }

        return maxProd;
    }
}