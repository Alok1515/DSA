class Solution {
public:
    vector<int> DFS(unordered_map<int, vector<int>> &adj, int u, int parent, vector<int>& result, string &labels) {
        vector<int> my_count(26, 0);
        char mylabel = labels[u];
        
        my_count[mylabel - 'a'] = 1;
        
        for(int &v : adj[u]) {
            if(v == parent)
                continue;
        
            vector<int> child_count(26, 0);
            child_count = DFS(adj, v, u, result, labels);

            for(int i = 0; i<26; i++) {
                my_count[i] += child_count[i];
            }
        }
        
        result[u] = my_count[mylabel - 'a'];
        
        return my_count;
    }
    
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        unordered_map<int, vector<int>> adj;
        
        for(auto &vec : edges) {
            int u = vec[0];
            int v = vec[1];
            
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        
        vector<int> result(n, 0);
        
        DFS(adj, 0, -1, result, labels);
        
        return result;
        
    }
};
