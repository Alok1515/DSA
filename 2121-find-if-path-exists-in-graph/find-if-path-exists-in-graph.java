class Solution {

    private boolean check(List<List<Integer>> graph, int node, int dest, boolean[] visited) {

        if(node == dest) return true;

        // if alreasy visited return false 
        if(visited[node]) return false;

        visited[node] = true; // mark the node as true

        for(int neighbor : graph.get(node)) {
            if(check(graph, neighbor, dest, visited)) {
                return true;
            }
        }

        return false;

    }
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

        return check(graph, source, destination, visited);
    }
}