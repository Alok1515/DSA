class Solution {

    private boolean hasCycle(int src, int dest, List<Integer>[] graph, boolean[] visited) {

        if(src == dest) return true;

        visited[src] = true;

        for(int neighbor : graph[src]) {
            if(!visited[neighbor]) {
               if( hasCycle(neighbor, dest, graph, visited)) return true;
            }
        }

        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;

        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n+1];

            if(!graph[u].isEmpty() && !graph[v].isEmpty() && hasCycle(u, v, graph, visited)) {
                return edge;
            }
            graph[u].add(v);
            graph[v].add(u);
        }
        return new int[0];
    }
}