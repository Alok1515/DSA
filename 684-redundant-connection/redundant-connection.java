class Solution {

    class DSU {
        int[] rank, parent;

        DSU(int n) {
            rank = new int[n];
            parent = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int u) {
            if(parent[u] != u) {
                parent[u] = find(parent[u]);
            }

            return parent[u];
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return;

            if(rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else if(rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else {
                parent[pu] = pv;
                rank[pv]++;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        DSU dsu = new DSU(n+1);
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(dsu.find(u) == dsu.find(v)) {
                return edge;
            }

            dsu.union(u, v);
        }

        return new int[0];
    }
}