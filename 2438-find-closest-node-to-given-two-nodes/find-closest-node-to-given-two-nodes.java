class Solution {
    int n;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];


        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dist1[node1] = 0;
        dist2[node2] = 0;


        dfs(node1, dist1, edges, n, visited1);
        dfs(node2, dist2, edges, n, visited2);

        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int maxD = Math.max(dist1[i], dist2[i]);

            if(minDistTillNow > maxD) {
                minDistTillNow = maxD;
                minDistNode = i;
            }
        }

        return minDistNode;
    }

    private void dfs(int node, int[] dist, int[] edges, int n, boolean[] visited) {

        // mark visited
        visited[node] = true;

        int neighbor = edges[node];

        if(neighbor != -1 && !visited[neighbor]) {
            visited[neighbor] = true;
            dist[neighbor] = 1 + dist[node];
            dfs(neighbor, dist, edges, n, visited);
        }
    }
}