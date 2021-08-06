// Runtime: 8 ms, faster than 98.97% of C++ online submissions for Shortest Path Visiting All Nodes.
// Memory Usage: 11.9 MB, less than 70.90% of C++ online submissions for Shortest Path Visiting All Nodes.


class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {

        int len = graph.size();

        vector<vector<int>> visit(len, vector<int>(1 << len));
        queue<tuple<int, int, int>> q;

        int res = 0;

        for (int i =0 ; i < len; i++) {

            q.emplace(i, 1 << i, 0);
            visit[i][1 << i] = true;
        }

        while (!q.empty()) {

            auto [label, mask, l] = q.front();
            q.pop();

            if (mask == (1 << len) - 1) {
                res = l;
                break;
            }

            for (int node: graph[label]) {
                int m = mask | 1 << node;
                if (!visit[node][m]) {
                    q.emplace(node, m, l + 1);
                    visit[node][m] = true;
                }
            }
        }

        return res;
    }
};