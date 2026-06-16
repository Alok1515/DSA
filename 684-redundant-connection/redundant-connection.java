class Solution {

    int n;

    private boolean hasCycle(int src, int dest, List<Integer>[] graph) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+ 1];

        q.offer(src);
        visited[src] = true;

        while(!q.isEmpty()) {

            int curr = q.poll();

            if(curr == dest) return true;

            for(int nei : graph[curr]) {
                if(!visited[nei]) {
                    q.offer(nei);
                    visited[nei] = true;
                }
            }
        }

        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        
        n = edges.length;

        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(!graph[u].isEmpty() && !graph[v].isEmpty() && hasCycle(u, v, graph)) {
                return edge;
            }
            graph[u].add(v);
            graph[v].add(u);
        }
        return new int[0];
    }
}