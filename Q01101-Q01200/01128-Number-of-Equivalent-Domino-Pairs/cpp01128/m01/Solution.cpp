// Runtime: 48 ms, faster than 67.93% of C++ online submissions for Number of Equivalent Domino Pairs.
// Memory Usage: 24.4 MB, less than 22.15% of C++ online submissions for Number of Equivalent Domino Pairs.
class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        int res = 0;
        vector<int> help(100);

        for (vector<int> domi : dominoes) {
            int cur = domi[0] > domi[1] ? domi[0] * 10 + domi[1] : domi[1] * 10 + domi[0];
            res += help[cur];
            help[cur]++;
        }

        return res;
    }
};