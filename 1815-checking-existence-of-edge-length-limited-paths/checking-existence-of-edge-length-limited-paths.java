class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {

            parent = new int[n];
            rank   = new int[n];

            // initially every one is its own parent
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int u) {
            if(parent[u] != u) {
                parent[u] = find(parent[u]); // path compression
            }

            return parent[u];
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return; // already in same set

            // union by rank
            if(rank[pu] == rank[pv]) {
                parent[pu] = pv; // attached pu to pv
            } else if(rank[pu] > rank[pv]) {
                parent[pv] = pv;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        
        // store the original query index
        int[][] q = new int[queries.length][4];

        for(int i = 0; i < queries.length; i++) {

            q[i][0] = queries[i][0]; // src
            q[i][1] = queries[i][1]; // dest
            q[i][2] = queries[i][2]; // limit
            q[i][3] = i; // store thr index

        }

        // sort edges by weight
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        // sort by limit
        Arrays.sort(q, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(n);

        boolean[] result = new boolean[queries.length];

        int edgeIndex = 0;

        for(int[] query : q) {

            int src = query[0];
            int dest = query[1];
            int limit = query[2];
            int originalIndex = query[3];

            // add all valid index
            while(edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                int u = edgeList[edgeIndex][0];
                int v = edgeList[edgeIndex][1];

                dsu.union(u, v); // merge u and v

                edgeIndex++;
            }

            // put true if they ahave same parent
            result[originalIndex] = dsu.find(src) == dsu.find(dest);
        }

        return result;
    }
}