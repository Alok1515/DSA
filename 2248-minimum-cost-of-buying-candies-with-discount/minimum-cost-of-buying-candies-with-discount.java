class Solution {
    public int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int n = cost.length;
        int minCost = 0;

        // Traverse from largest to smallest
        for(int i = n - 1; i >= 0; i -= 3) {

            minCost += cost[i];

            if(i - 1 >= 0) {
                minCost += cost[i - 1];
            }
        }

        return minCost;
    }
}