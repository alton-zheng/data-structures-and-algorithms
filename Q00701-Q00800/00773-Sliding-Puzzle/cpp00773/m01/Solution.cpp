// Runtime: 8 ms, faster than 87.83% of C++ online submissions for Sliding Puzzle.
// Memory Usage: 10.3 MB, less than 40.76% of C++ online submissions for Sliding Puzzle.
// bfs
class Solution {
private:
    vector<vector<int>> neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
public:
    int slidingPuzzle(vector<vector<int>>& board) {

        int outer = board.size(), inner = board[0].size();
        string target = "123450";

        string initial;

        for (int o = 0; o < outer; o++) {
            for (int i = 0; i < inner; i++) {
                initial += board[o][i] + '0';
            }
        }

        if (initial == target) {
            return 0;
        }

        auto get = [&](string& cur) -> vector<string> {
            vector<string> ret;
            int idx = cur.find('0');
            for (int i : neighbors[idx]) {
                swap(cur[idx], cur[i]);
                ret.push_back(cur);
                swap(cur[idx], cur[i]);
            }
            return ret;
        };

        queue<pair<string, int>> q;
        q.emplace(initial, 0);
        unordered_set<string> seam = {initial};

        while (!q.empty()) {
            auto [status, step] = q.front();
            q.pop();

            for (string nextStatus: get(status)) {
                if (!seam.count(nextStatus)) {
                    if (nextStatus == target) {
                        return step + 1;
                    }

                    q.emplace(nextStatus, step + 1);
                    seam.insert(move(nextStatus));

                }
            }
        }

        return -1;

    }
};