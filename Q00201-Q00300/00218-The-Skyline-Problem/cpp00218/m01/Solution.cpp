// Runtime: 28 ms, faster than 82.26% of C++ online submissions for The Skyline Problem.
// Memory Usage: 13.7 MB, less than 91.25% of C++ online submissions for The Skyline Problem.
class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {

        int len = buildings.size();
        auto cp = [](const pair<int, int>& a, const pair<int, int>& b) -> bool {return a.second < b.second; };
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(cp)> q(cp);

        vector<int> boundaries;
        for (vector<int>& building : buildings) {
            boundaries.push_back(building[0]);
            boundaries.push_back(building[1]);
        }

        sort(boundaries.begin(), boundaries.end());

        vector<vector<int>> res;
        int curIdx = 0;
        for (auto& boundary : boundaries) {
            while (curIdx < len && buildings[curIdx][0] <= boundary) {
                q.emplace(buildings[curIdx][1], buildings[curIdx][2]);
                curIdx++;
            }
            while (!q.empty() && q.top().first <= boundary) {
                q.pop();
            }

            int hmax = q.empty() ? 0 : q.top().second;
            if (res.size() == 0 || hmax != res.back()[1]) {
                res.push_back({boundary, hmax});
            }
        }
        return res;
    }
};