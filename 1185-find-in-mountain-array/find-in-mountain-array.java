/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

// 1. find peak index 
// 2. bs from 0 to peak index
// 3. bs from peak index to n-1
 
class Solution {

    int n;

    private int peakIndex(MountainArray mountainArr) {

        if(n == 1) return 0;

        if(mountainArr.get(0) > mountainArr.get(1)) return 0;
        if(mountainArr.get(n-1) > mountainArr.get(n-2)) return n-1;

        int l = 1, r = n-2;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(mountainArr.get(mid-1) < mountainArr.get(mid) && mountainArr.get(mid + 1) <
                mountainArr.get(mid)) {

                return mid;
            } else if(mountainArr.get(mid) > mountainArr.get(mid-1)) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return -1;
    }

    private int binarySearch(MountainArray mountainArr, int target, int l, int r, boolean isAsc) {

          while(l <= r) {

            int mid = l + (r-l) / 2;
            int val = mountainArr.get(mid);

            if(val == target) {
                return mid;
            }

            if(isAsc) {

                if(val > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {

                if(val > target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {

        n = mountainArr.length();
        
        int peak = peakIndex(mountainArr); 

        int bsUntilPeak = binarySearch(mountainArr, target, 0, peak, true);

        int bsFromPeak = binarySearch(mountainArr, target, peak + 1, n-1, false);
        
        return bsUntilPeak == -1 ? bsFromPeak : bsUntilPeak;
    }
}