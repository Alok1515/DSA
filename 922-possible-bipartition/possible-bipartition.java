class Solution {

    private boolean bfsCheckBipartite(List<List<Integer>> graph, int node, int[] color) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(node);
        color[node] = 1; // mark the color as 1

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int neighbor : graph.get(curr)) {
                if(color[neighbor] == color[curr]) { // both should not have same color
                    return false;
                }

                if(color[neighbor] == -1) {
                    q.offer(neighbor);
                    color[neighbor] = 1 - color[curr]; // keep the color diffrent
                }
            }
        }

        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        // create a adj list
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // make a bidirectional graph
        for(int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] color = new int[n+1];


        // fill the color with -1
        Arrays.fill(color, -1);

        for(int i = 1; i <= n; i++) {
            if(color[i] == -1) {
                if(bfsCheckBipartite(graph, i, color) == false) return false;
            }
        }

        return true;
    }
}