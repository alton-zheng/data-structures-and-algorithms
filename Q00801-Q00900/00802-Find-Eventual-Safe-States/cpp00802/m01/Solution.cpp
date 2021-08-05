// Runtime: 136 ms, faster than 86.36% of C++ online submissions for Find Eventual Safe States.
// Memory Usage: 47.2 MB, less than 66.19% of C++ online submissions for Find Eventual Safe States.
class Solution {

private:
    bool isSafe(vector<vector<int>>& graph, vector<int>& color, int i) {
        if (color[i] > 0) {
            return color[i] == 2;
        }

        color[i] = 1;

        for (int g: graph[i]) {
            if (!isSafe(graph, color, g)) {
                return false;
            }
        }

        color[i] = 2;
        return true;
    }


public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {

        int len = graph.size();

        vector<int> color(len);
        vector<int> res;

        for (int i = 0; i < len; i++)  {
            if (isSafe(graph, color, i)) {
                res.push_back(i);
            }
        }

        return res;
    }
};