class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) {
            return true;
        }

        // create an adj list
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true; // mark it as visited

        while(!q.isEmpty()) {
            int node = q.poll();

            if(node == destination) return true;

            for(int neighbor : graph.get(node)) {
                if(!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return false;
    }
}