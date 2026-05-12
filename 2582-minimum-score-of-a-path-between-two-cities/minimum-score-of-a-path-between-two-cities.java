class Solution {
    private int minScore = Integer.MAX_VALUE;

    class Pair {
        int node;
        int distance;
        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // build bi- directional graph
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];

            adj.get(u).add(new Pair(v, dist));
            adj.get(v).add(new Pair(u, dist));
        }

        boolean[] visited = new boolean[n+1];
        dfs(1, roads, adj, visited);

        return minScore;
    }

    private void dfs(int node, int[][] roads,  List<List<Pair>> adj, boolean[] visited) {

        visited[node] = true;

        for(Pair neighbor : adj.get(node)) {

            // update min score
            minScore = Math.min(minScore, neighbor.distance);
            if(!visited[neighbor.node]) {
                dfs(neighbor.node, roads, adj, visited);
            }
        }
    }
}