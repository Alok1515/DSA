class Solution {

    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank   = new int[n];

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
    public int removeStones(int[][] stones) {
        
        int groups = 0;
        int n = stones.length;

        DSU dsu = new DSU(n);

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {

                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(dsu.find(i) == i) {
                groups++;
            }
        }

        return n - groups;
    }
}