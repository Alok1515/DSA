class Solution {

    private boolean dfs(int u, int v, List<Integer>[] adj, boolean[] visited) {

        if(u == v) return true;

        visited[u] = true;

        for(int nei : adj[u]) {
            if(!visited[nei]) {
               if(dfs(nei, v, adj, visited)) return true;
            }
        }

        return false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        

       List<Integer>[] adj = new ArrayList[numCourses];

       for(int i = 0; i < numCourses; i++) {
           adj[i] = new ArrayList<>();
       }

       for(int[] pre : prerequisites) {
           int u = pre[0];
           int v = pre[1];

           adj[u].add(v);
       }

       List<Boolean> ans = new ArrayList<>();


       for(int[] query : queries) {
           int u = query[0];
           int v = query[1];

           boolean[] visited = new boolean[numCourses];

           ans.add(dfs(u, v, adj, visited));
       }

       return ans;
    }
}