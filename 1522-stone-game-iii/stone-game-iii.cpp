class Solution {
public:
    int Alice = 1; 
    int Bob = 0;
    int n;
    
    int miniMax(vector<int>& stoneValue, int player, int i, vector<vector<int>>& t) {
        if(i >= n)
            return 0;
        
        if (t[player][i] != -1) 
            return t[player][i];
        
        int result = player == Alice ? INT_MIN : INT_MAX;
        
        int stones = 0;
        
        for (int j = i; j < min(i+3, n); j++) {
            if (player == Alice) {
                stones += stoneValue[j];
                result = max(result, stones + miniMax(stoneValue, Bob, j + 1, t));
            } else {
                stones -= stoneValue[j];
                result = min(result, stones + miniMax(stoneValue, Alice, j + 1, t));
            }
        }
        return t[player][i] = result;
        
        
    }
    
    string stoneGameIII(vector<int>& stoneValue) {
        n = stoneValue.size();
        vector<vector<int>> t(2, vector<int>(n+1, -1));
        int diff = miniMax(stoneValue, 1, 0, t);
        
        if(diff > 0)
            return "Alice";
        else if(diff < 0)
            return "Bob";
        
        return "Tie";
    }
};