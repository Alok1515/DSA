class Solution {

    private void bfs(int u, List<List<Integer>> adj, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(u);

        while(!q.isEmpty()) {

            int curr = q.poll();

            for(int neighbor : adj.get(curr)) {

                if(!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    private boolean isSimilar(String s1, String s2) {

        int diff = 0;

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 0 || diff == 2;
    }

    public int numSimilarGroups(String[] strs) {

        int n = strs.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (isSimilar(strs[i], strs[j])) {

                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                bfs(i, adj, visited);

                count++;
            }
        }

        return count;
    }
}