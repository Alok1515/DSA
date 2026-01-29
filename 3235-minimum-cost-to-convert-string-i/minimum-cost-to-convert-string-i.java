public class Solution {
    static class Pair {
        int key;
        char value;

        public Pair(int key, char value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public char getValue() {
            return value;
        }
    }

    void dijkstra(Map<Character, ArrayList<Pair>> adj, char source, int[][] distances) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        pq.add(new Pair(0, source));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int d = current.getKey();
            char node = current.getValue();

            for (Pair child : adj.getOrDefault(node, new ArrayList<>())) {
                char adjNode = child.getValue();
                int distance = child.getKey();

                if (distances[source - 'a'][adjNode - 'a'] > distance + d) {
                    distances[source - 'a'][adjNode - 'a'] = distance + d;
                    pq.add(new Pair(distance + d, adjNode));
                }
            }
        }
    }

    long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        Map<Character, ArrayList<Pair>> adj = new HashMap<>();

        for (int i = 0; i < original.length; i++) {
            adj.computeIfAbsent(original[i], k -> new ArrayList<>()).add(new Pair(cost[i], changed[i]));
        }

        int[][] distances = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        // Populate distances using Dijkstra's
        for (char it : original) {
            dijkstra(adj, it, distances);
        }

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) continue;

            if (distances[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE)
                return -1;

            else ans += distances[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }

        return ans;
    }
}