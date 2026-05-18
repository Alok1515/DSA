class Solution {

    class Pair {

        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        // build an adj graph
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }

        int[] visited = new int[n];

        // max heap based on probability
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));

        
        double[] best = new double[n];

        best[start_node] = 1.0; // prob of reaching to itself 

        pq.offer(new Pair(start_node, 1.0));

        while(!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            double prob = curr.prob;

            if(node == end_node) return prob;

            for(Pair neighbor : adj.get(node)) {

                int nextNode = neighbor.node;
                double newProb = prob * neighbor.prob;

                if(newProb > best[nextNode]) {
                    best[nextNode] = newProb;

                    pq.offer(new Pair(nextNode, newProb));
                }
            }
        }

        return 0.0;
    }
}