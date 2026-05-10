class Solution {

    int result = 0;

    private int dfs(List<List<Integer>> adj, int curr, int parent, String s) {

        int longest = 0;
        int secondLongest = 0;

        for(int child : adj.get(curr)) {

            if(child == parent) {
                continue;
            }

            int childLongestLength = dfs(adj, child, curr, s);

            if(s.charAt(child) == s.charAt(curr)) {
                continue;
            }

            if(childLongestLength > secondLongest) {
                secondLongest = childLongestLength;
            }

            if(secondLongest > longest) {
                int temp = longest;
                longest = secondLongest;
                secondLongest = temp;
            }
        }

        int koiEkAcha = Math.max(longest, secondLongest) + 1;

        int onlyRootAcha = 1;

        int neecheHiMilgayaAnswer = longest + secondLongest + 1;

        result = Math.max(
                    result,
                    Math.max(
                        neecheHiMilgayaAnswer,
                        Math.max(koiEkAcha, onlyRootAcha)
                    )
                 );

        return Math.max(koiEkAcha, onlyRootAcha);
    }

    public int longestPath(int[] parent, String s) {

        int n = parent.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {

            int u = i;
            int v = parent[i];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(adj, 0, -1, s);

        return result;
    }
}