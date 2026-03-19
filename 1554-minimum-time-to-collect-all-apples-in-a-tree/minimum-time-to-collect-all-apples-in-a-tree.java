class Solution {

    private int dfs(List<List<Integer>> graph, int curr, int parent, List<Boolean> hasApple) {

        int time = 0;

        for(int child : graph.get(curr)) {
            if(child == parent) continue; // skip revisiting parent

            int timeTakenByChild = dfs(graph, child, curr, hasApple);

            if(timeTakenByChild > 0 || hasApple.get(child) == true) {

                time += timeTakenByChild + 2; // add the time
            }
        }

        return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        // create garph 
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build an adj list
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return dfs(graph, 0, -1, hasApple);
    }
}