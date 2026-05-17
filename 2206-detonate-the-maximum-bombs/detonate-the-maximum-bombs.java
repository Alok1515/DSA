class Solution {

    private int dfs(int node, List<List<Integer>> adj, Set<Integer> visited) {

        visited.add(node);

        int count = 1;

        for(int neighbor : adj.get(node)) {

            if(!visited.contains(neighbor)) {
                count += dfs(neighbor, adj, visited);
            }
        }

        return count;
    }

    public int maximumDetonation(int[][] bombs) {

        int n = bombs.length;
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                if(i == j) continue;

                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x2 - x1;
                long dy = y2 - y1;

                if(dx * dx + dy * dy <= r1 * r1) {
                    adj.get(i).add(j);
                }
            }
        }

        int result = 0;

        for(int i = 0; i < n; i++) {

            Set<Integer> visited = new HashSet<>();

            result = Math.max(result, dfs(i, adj, visited));
        }

        return result;
    }
}