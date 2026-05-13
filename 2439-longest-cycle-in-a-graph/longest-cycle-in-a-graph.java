class Solution {

    private int longestCycle = -1;

    private void dfs(int node, int[] edges, boolean[] visited, boolean[] pathVisited, int[] depth, int currDepth) {

        // mark it as visited 
        visited[node] = true;
        pathVisited[node] = true;

        depth[node] = currDepth;

        int neighbor = edges[node];

        if(neighbor != -1) {

            // unvisted node
            if(!visited[neighbor]) {
                dfs(neighbor, edges, visited, pathVisited, depth, currDepth + 1);
            }

            // cycle detectde
            else if(pathVisited[neighbor]) {

                longestCycle = Math.max(longestCycle, currDepth - depth[neighbor] + 1);
            }
        }

        // backtrack
        pathVisited[node] = false;
    }
    public int longestCycle(int[] edges) {
        
        int n = edges.length;

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        int[] depth = new int[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, edges, visited, pathVisited, depth, 0);
            }
        }

        return longestCycle;
    }
}