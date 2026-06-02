class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        Arrays.sort(arr2);

        int ans = solve(0, Integer.MIN_VALUE, arr1, arr2);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int i, int prev, int[] arr1, int[] arr2) {

        // base case -> exhausted the arr1
        if(i == arr1.length) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        String key = i + "," + prev;

        if(map.containsKey(key)) return map.get(key);

        // option 1 -> keep arr[i]
        if(arr1[i] > prev) {
            ans = solve(i+1, arr1[i], arr1, arr2);
        }

        // option 2 -> replace the arr[i]
        int idx = upperBound(arr2, prev);

        if(idx < arr2.length) {
            int temp = solve(i+1, arr2[idx], arr1, arr2);

            if(temp != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + temp);
            }
        }

        map.put(key, ans);

        return ans;
    }

    private int upperBound(int[] arr2, int target) {

        int low = 0;
        int high = arr2.length-1;
        int result = arr2.length;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr2[mid] > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}