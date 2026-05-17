class Solution {

    class Pair {
        String node;
        double weight;

        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public double dfs(String src, String dest, Set<String> visited,  Map<String, List<Pair>> adj, double product) {

        if(src.equals(dest)) return product;

        visited.add(src);

        for(Pair neighbor : adj.get(src)) {

            String nextNode = neighbor.node;
            double weight   = neighbor.weight;

            if(!visited.contains(nextNode)) {

                double result = dfs(nextNode, dest, visited, adj, product * weight);

                if(result != -1.0) return result;
            } 
        }

        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int n = equations.size();
        
        // adj list
        Map<String, List<Pair>> adj = new HashMap<>();

        for(int i = 0; i < n; i++) {

            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            double val  = values[i];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new Pair(v, val));
            adj.get(v).add(new Pair(u, 1.0 / val));
        }

        double[] result = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {

            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if(!adj.containsKey(src) || !adj.containsKey(dest)) {

                result[i] = -1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();

            result[i] = dfs(src, dest, visited, adj, 1.0);
        }

        return result;
    }
}