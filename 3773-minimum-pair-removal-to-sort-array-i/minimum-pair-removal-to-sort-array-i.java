class Solution {
    private int minPairSum(List<Integer> nums) {
        int minSum = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0; i < nums.size() - 1; i++) {
            int sum = nums.get(i) + nums.get(i + 1);
            if(sum < minSum) {
                minSum = sum;
                index = i;
            }
        }

        return index;
    }

    private boolean isSorted(List<Integer> nums) {
        for(int i = 0; i < nums.size() - 1; i++) {
            if(nums.get(i) > nums.get(i + 1)) {
                return false;
            } 
        }

        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums) {
            list.add(num);
        }

        int operations = 0;

        while(!isSorted(list)) {
            int index = minPairSum(list);

            int merged = list.get(index) + list.get(index + 1);
            list.set(index, merged);
            list.remove(index + 1);

            operations++;
        }

        return operations;
    }
}