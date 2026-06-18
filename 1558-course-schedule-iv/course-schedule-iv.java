class Solution {

    int n;

    private boolean bfs(int u, int v, List<Integer>[] adj) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(u);

        visited[u] = true;

        while(!q.isEmpty()) {

            int size = q.size();

            while(size-- > 0) {

                int curr = q.poll();

                for(int nei : adj[curr]) {

                    if(nei == v) return true;

                    if(!visited[nei]) {
                        visited[nei] = true;
                        q.offer(nei);
                    }
                }
            }
        }

        return false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
       n = numCourses;

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

           ans.add(bfs(u, v, adj));
       }

       return ans;
    }
}