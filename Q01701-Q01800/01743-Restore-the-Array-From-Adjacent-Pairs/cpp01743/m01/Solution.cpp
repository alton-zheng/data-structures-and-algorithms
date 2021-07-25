// Runtime: 578 ms, faster than 46.81% of C++ online submissions for Restore the Array From Adjacent Pairs.
// Memory Usage: 112.4 MB, less than 75.78% of C++ online submissions for Restore the Array From Adjacent Pairs.
class Solution {
public:
    vector<int> restoreArray(vector<vector<int>>& adjacentPairs) {
        unordered_map<int, vector<int>> help;
        for (vector<int>& adjacentPair : adjacentPairs) {
            help[adjacentPair[0]].push_back(adjacentPair[1]);
            help[adjacentPair[1]].push_back(adjacentPair[0]);
        }

        int len = adjacentPairs.size() + 1;
        vector<int> ret(len);
        for (auto& [e, adj] : help) {
            if (adj.size() == 1) {
                ret[0] = e;
                ret[1] = adj[0];
                break;
            }
        }

        for (int i = 2; i < len; i++) {
            vector<int> adj = help[ret[i - 1]];
            ret[i] = ret[i - 2] == adj[0] ? adj[1] : adj[0];
        }
        return ret;
    }
};