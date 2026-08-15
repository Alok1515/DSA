class Solution {
    public int longestSubsequence(int[] nums) {
         int[] arr = nums; // store midway

        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }

        if (xor != 0) return arr.length;

        boolean allZero = true;
        for (int num : arr) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }

        return allZero ? 0 : arr.length - 1;
    }
}