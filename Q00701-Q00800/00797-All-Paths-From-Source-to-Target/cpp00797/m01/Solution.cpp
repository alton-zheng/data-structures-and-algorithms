// Runtime: 12 ms, faster than 80.97% of C++ online submissions for All Paths From Source to Target.
// Memory Usage: 11.9 MB, less than 65.52% of C++ online submissions for All Paths From Source to Target.
class Solution {
private:
    vector<vector<int>> res;
    vector<int> queue;

    void dfs(vector<vector<int>>& graph, int cur, int target) {
        if (cur == target) {
            res.push_back(queue);
            return;
        }
        for (auto& g : graph[cur]) {
            queue.push_back(g);
            dfs(graph, g, target);
            queue.pop_back();
        }
    }

public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        queue.push_back(0);
        dfs(graph, 0, graph.size() - 1);
        return res;
    }
};