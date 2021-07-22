// Runtime: 376 ms, faster than 80.21% of C++ online submissions for Minimum Area Rectangle.
// Memory Usage: 19.3 MB, less than 99.67% of C++ online submissions for Minimum Area Rectangle.
class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {

        unordered_set<int> help;

        for (vector<int>& point: points) {
            help.emplace(40001 * point[0] + point[1]);
        }

        int len = points.size();

        int res = INT_MAX;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {

                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (help.count(points[i][0]* 40001 + points[j][1])
                    && help.count(points[j][0] * 40001 + points[i][1])) {
                        res = min(res, abs(points[j][1] - points[i][1]) * abs(points[j][0] - points[i][0]));
                    }
                }
            }
        }

        return res < INT_MAX ? res: 0;


    }
};