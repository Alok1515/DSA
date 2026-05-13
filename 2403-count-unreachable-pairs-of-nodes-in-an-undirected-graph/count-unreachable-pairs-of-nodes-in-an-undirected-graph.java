class Solution {

    private long dfs(int node, List<List<Integer>> adj, boolean[] visited) {

        visited[node] = true;

        long size = 1;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, adj, visited);
            }
        }

        return size;
    }

    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        long remainingNodes = n;
        long result = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                long size = dfs(i, adj, visited);

                result += size * (remainingNodes - size);

                remainingNodes -= size;
            }
        }

        return result;
    }
}