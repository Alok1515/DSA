class Solution {
    class DSU {
        int[] parent;
        int[] rank;
        int component;

        DSU(int n) {
            parent = new int[n+1];
            rank = new int[n+1];
            component = n;

            // initially every one is its own parent
            for(int i = 0; i <= n; i++) {
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

            if(pu == pv) return;

            if(rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if(rank[pu] > rank[pv]) {
                parent[pv] = pu;
            } else {
                parent[pu] = pv;
                rank[pu]++;
            }
            component--; // decrease the component if we perforn union
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        // two dsu call
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        // sort edges by type in desc
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        int edgeCount = 0;

        for(int[] edge : edges) {

            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(type == 3) {

                boolean edgeAddedOrNot = false;

                // Alice
                if(alice.find(u) != alice.find(v)) {
                    alice.union(u, v);
                    edgeAddedOrNot = true;
                }

                // Bob
                if(bob.find(u) != bob.find(v)) {
                    bob.union(u, v);
                    edgeAddedOrNot = true;
                }

                if(edgeAddedOrNot == true) {
                    edgeCount++;
                }
            } else if(type == 2) {
                
                // Alice
                if(alice.find(u) != alice.find(v)) {
                    alice.union(u, v);
                    edgeCount++;
                }
            } else {

                // Bob
                if(bob.find(u) != bob.find(v)) {
                    bob.union(u, v);
                    edgeCount++;
                }                
            }
        }

        if(alice.component != 1 || bob.component != 1) return -1;

        return edges.length - edgeCount;
    }
}