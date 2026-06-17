class Solution {

    private long dijkstra(int n, int[][] edges, int source, int destination) {

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            if (edge[2] == -1) continue;

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[source] = 0;
        pq.offer(new long[]{source, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            int node = (int) curr[0];
            long d = curr[1];

            if (d > dist[node]) continue;

            for (int[] nei : graph[node]) {

                int next = nei[0];
                int wt = nei[1];

                if (dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    pq.offer(new long[]{next, dist[next]});
                }
            }
        }

        return dist[destination];
    }

    public int[][] modifiedGraphEdges(int n,
                                      int[][] edges,
                                      int source,
                                      int destination,
                                      int target) {

        long currDist = dijkstra(n, edges, source, destination);

        if (currDist < target) {
            return new int[0][];
        }

        boolean matchedTarget = (currDist == target);

        for (int[] edge : edges) {

            if (edge[2] != -1) continue;

            if (matchedTarget) {
                edge[2] = 2_000_000_000;
                continue;
            }

            edge[2] = 1;

            long newDist =
                    dijkstra(n, edges, source, destination);

            if (newDist <= target) {

                matchedTarget = true;

                edge[2] += (target - newDist);

            }
        }

        if (!matchedTarget) {
            return new int[0][];
        }

        return edges;
    }
}