class Solution {
    class DSU {
        int[] rank;
        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int u) {
            if(parent[u] != u) {
                parent[u] = find(parent[u]);
            }

            return parent[u];
        }

        public void union(int u, int v) {

            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return;

            if(rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if(rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);

        // Build a componenet graph
        for(int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        int[] compAND = new int[n];
        Arrays.fill(compAND, -1);

        // AND of all edges in each component
        for(int[] edge : edges) {
            int root = dsu.find(edge[0]);

            if(compAND[root] == -1) {
                compAND[root] = edge[2];
            } else {
                compAND[root] &= edge[2];
            }
        }

        int m = query.length;
        int[] ans = new int[m];

        for(int i = 0; i < m; i++) {

            int s = query[i][0];
            int t = query[i][1];

            if(s == t) { // same node
                ans[i] = 0;
                continue;
            }

            int rs = dsu.find(s);
            int rt = dsu.find(t);

            if(rs != rt) {
                ans[i] = -1;
            } else {
                ans[i] = compAND[rs];
            }
        }

        return ans;
    }
}