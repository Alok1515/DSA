class Solution {
public:
    int binaryGap(int n) {
        int prev = -1;

        int result = 0;

        for(int curr = 0; curr < 32; curr++) {
            if(((n >> curr) & 1) > 0) {
                result = (prev != -1) ? max(result, curr-prev) : result;
                prev = curr;
            }
        }

        return result;
    }
};