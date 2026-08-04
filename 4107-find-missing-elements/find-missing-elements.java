class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> st = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int num : nums) {
            st.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for(int i = min + 1; i < max; i++) {
            if(!st.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}