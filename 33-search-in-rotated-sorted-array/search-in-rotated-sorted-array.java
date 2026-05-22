class Solution {

    private int findPivot(int[] nums, int n) {

        int l = 0, r = n-1;

        while(l < r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r; //pivot index
    }

    private int binarySearch(int l, int r, int[] nums, int target) {

        int idx = -1;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] == target) {
                idx = mid;
                break;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return idx;
    }
    public int search(int[] nums, int target) {
        
        int n = nums.length;

        int pivotIndex = findPivot(nums, n);

        int index = binarySearch(0, pivotIndex - 1, nums, target); // left side of pivot index

        if(index != -1) return index;

        index = binarySearch(pivotIndex, n - 1, nums, target);

        return index;
    }
}