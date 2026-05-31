class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int n = worker.length;

        Arrays.sort(worker);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int maxProfit = 0;

        for(int i = 0; i < profit.length; i++) {
            maxHeap.offer(new int[]{profit[i], difficulty[i]});
        }

        for(int i = n-1; i >= 0; i--) {
        
            // difficulty is high for the worker
            while(!maxHeap.isEmpty() && maxHeap.peek()[1] > worker[i]) {
                maxHeap.poll();
            } 

            if(!maxHeap.isEmpty() && maxHeap.peek()[1] <= worker[i]) {
                maxProfit += maxHeap.peek()[0];
            }
        }

        return maxProfit;
    }
}