class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            int shift = nums[i] % n; // keep shift within array

            int newIndex = (i + shift) % n;

            if(newIndex < 0) {
                newIndex += n;
            }

            result[i] = nums[newIndex];
        }

        return result;
    }
}