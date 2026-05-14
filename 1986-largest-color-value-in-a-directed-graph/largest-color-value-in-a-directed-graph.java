class Solution {
    public int largestPathValue(String colors, int[][] edges) {

        int n = colors.length();
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        // build an adj graph
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // calculate the indegree
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        // freq table 
        int[][] freq = new int[n][26];

        Queue<Integer> q = new LinkedList<>();

        // add all node which has indegree 0
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int answer = 0;
        int countNodes = 0;

        // BFS Traversal
        while(!q.isEmpty()) {

            int node = q.poll();
            countNodes++;

            int colorIndex = colors.charAt(node) - 'a';

            // include current node color
            freq[node][colorIndex]++;

            answer = Math.max(answer, freq[node][colorIndex]);

            // now explore the neighbor 
            for(int neighbor : adj.get(node)) {

                // propagate through all color
                for(int c = 0; c < 26; c++) {
                    freq[neighbor][c] = Math.max(freq[neighbor][c], freq[node][c]);
                }

                indegree[neighbor]--;

                if(indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }               
        }

        return n == countNodes ? answer : -1;
    }
}