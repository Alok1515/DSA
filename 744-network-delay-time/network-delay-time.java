class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];

            graph[u].add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k-1] = 0;

        pq.offer(new int[]{k-1, 0});
        int minTime = 0;

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int currDist = curr[1];

            if(currDist > dist[node]) continue;

            for(int[] nei : graph[node]) {
                int next = nei[0];
                int w    = nei[1];

                int newDist = currDist + w;

                if(newDist < dist[next]) {
                    dist[next] = newDist;
                    pq.offer(new int[]{next, newDist});
                }
            }
        }

        int ans = 0;

        for(int d : dist) {

            if(d == Integer.MAX_VALUE) {
                return -1;
            }
                ans = Math.max(ans, d);
            }

        return ans;
    }
}