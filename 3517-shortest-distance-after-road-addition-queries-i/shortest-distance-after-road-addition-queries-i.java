class Solution {

    private int bfs(List<Integer>[] graph, int n) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;
        int distance = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {
                int curr = q.poll();

                if(curr == n-1) return distance;

                for(int nei : graph[curr]) {
                    if(!visited[nei]) {
                        q.offer(nei);
                        visited[nei] = true;
                    }
                }
            }
            distance++;
        }

        return -1;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        
        List<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            graph[i].add(i+1);
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            graph[u].add(v);

            ans[i] = bfs(graph, n);
        }
        return ans;
    }
}