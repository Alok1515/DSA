class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int maxEl = 0;
        for(int num : nums) {
            maxEl = Math.max(maxEl, num);
        }
        int T = 1;
        while(T <= maxEl) {
            T <<= 1; //T = T*2
        }
        boolean[] s1 = new boolean[T]; //XOR pair values set to true
        boolean[] s2 = new boolean[T]; //XOR triplet values set to true
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                s1[nums[i] ^ nums[j]] = true;
            }
        }
        for(int i = 0; i < T; i++) {
            if(s1[i] == true) {
                for(int num : nums) {
                    s2[i ^ num] = true;
                }
            }
        }
        int count = 0; //unique xor count
        for(int i = 0; i < T; i++) {
            if(s2[i] == true)
                count++;
        }
        return count;
    }
}