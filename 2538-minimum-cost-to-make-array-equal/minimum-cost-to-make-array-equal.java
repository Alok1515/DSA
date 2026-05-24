class Solution {

    private long getCost(int[] nums, int[] cost, int target) {

        long totalCost = 0;

        for(int i = 0; i < nums.length; i++) {

            totalCost += 1L * Math.abs(nums[i] - target) * cost[i];
        }

        return totalCost;
    }

    public long minCost(int[] nums, int[] cost) {

        int l = Arrays.stream(nums).min().getAsInt();
        int r = Arrays.stream(nums).max().getAsInt();

        long answer = Long.MAX_VALUE;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);

            answer = Math.min(cost1, cost2);

            if(cost1 > cost2) {

                l = mid + 1;

            } else {

                r = mid - 1;
            }
        }

        return answer;
    }
}