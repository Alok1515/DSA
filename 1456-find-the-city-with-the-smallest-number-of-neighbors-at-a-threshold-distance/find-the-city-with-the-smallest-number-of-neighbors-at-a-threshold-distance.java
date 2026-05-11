class Solution {
    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build adj list
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int minReachableCities = Integer.MAX_VALUE;
        int answerCity = -1;

        // run dijkstras's for for every city
        for(int city = 0; city < n; city++) {
            int reachableCity = dijkstra(city, adj, n, distanceThreshold);

            if(reachableCity <= minReachableCities) {
                minReachableCities = reachableCity;
                answerCity = city;
            }
        }

        return answerCity;
    }

    private int dijkstra(int source, List<List<Pair>> adj, int n, int distanceThreshold) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        pq.offer(new Pair(source, 0));

        while(!pq.isEmpty()) {

            Pair curr = pq.poll();

            int currNode = curr.node;
            int currDist = curr.dist;

            // Skip outdated entries
            if(currDist > dist[currNode]) {
                continue;
            }

            for(Pair ngbr : adj.get(currNode)) {
                int nextNode = ngbr.node;
                int nextDist = ngbr.dist;

                if(currDist + nextDist < dist[nextNode]) {
                    dist[nextNode] = currDist + nextDist;

                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        int reachableCount = 0;

        for(int city = 0; city < n; city++) {

            if(city != source && dist[city] <= distanceThreshold) {
                reachableCount++;
            }
        }

        return reachableCount;
    }
}