

// Runtime: 252 ms, faster than 100.00% of C++ online submissions for Find the Longest Valid Obstacle Course at Each Position.
// Memory Usage: 123.3 MB, less than 33.33% of C++ online submissions for Find the Longest Valid Obstacle Course at Each Position.


class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {

        vector<int> cur, ans;

        for (int ob: obstacles) {
            if (cur.size() == 0 || ob >= cur.back()) {
                cur.push_back(ob);
                ans.push_back(cur.size());
            } else {
                int idx = upper_bound(cur.begin(), cur.end(), ob) - cur.begin();
                cur[idx] = ob;
                ans.push_back(idx + 1);
            }
        }

        return ans;
    }
};