class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;

        if(n % k != 0) return false;

        // store the numbers into sorted order
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // count the frequency
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while(!map.isEmpty()) {
            int curr = map.firstKey(); // gets the smallest key in the map

            for(int i = 0; i < k; i++) {
                if(!map.containsKey(curr + i)) return false; // element not present int map

                // otherwise reduce the frequency
                map.put(curr + i, map.get(curr + i) - 1); 
                if(map.get(curr + i) == 0) {
                    map.remove(curr + i);
                }
            }
        }

        return true;
    }
}