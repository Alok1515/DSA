class Solution {
    int n;

    private boolean check(int mid, int n, long k, List<int[]>[] adj) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[0] = 0;
        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()) {

            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];

            if(d > k) return false;

            if(node == n-1) return true;

            if(d > dist[node]) continue;

            for(int[] nei : adj[node]) {
                int adjNode = nei[0];
                int edgeCost = nei[1];

                if(edgeCost < mid) continue;

                if(d + edgeCost < dist[adjNode]) {
                    dist[adjNode] = d + edgeCost;
                    pq.offer(new long[]{d + edgeCost, adjNode});
                }
            }
        }

        return false;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        n = online.length;
        
        List<int[]>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int l = Integer.MAX_VALUE;
        int r = 0;

        for(int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(!online[u] || !online[v]) continue;

            adj[u].add(new int[]{v, w});

            l = Math.min(l, w);
            r = Math.max(r, w);
        }

        int answer = -1;

        while(l <= r) {
            int mid = l + (r-l) / 2;

            if(check(mid, n, k, adj)) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return answer;
    }
}