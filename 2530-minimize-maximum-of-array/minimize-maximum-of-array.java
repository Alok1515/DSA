class Solution {

    private boolean isValid(int[] nums, int mid) {

        int n = nums.length;

        long[] arr = new long[nums.length];

        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        for(int i = 0; i < nums.length-1; i++) {

            if(arr[i] > mid) return false;

            long buffer = mid - arr[i];
            arr[i+1]    = arr[i+1] - buffer;
        }

        return arr[n-1] <= mid;
    }
    public int minimizeArrayValue(int[] nums) {
        
       int l = 1, r = Arrays.stream(nums).max().getAsInt();
       int[] arr = new int[nums.length];
       int result = r;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(isValid(nums, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}