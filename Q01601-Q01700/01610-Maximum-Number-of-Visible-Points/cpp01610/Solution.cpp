class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int ang, vector<int>& location) {
        int ans = 0;

        vector<double> angle;

        for(const auto &point : points) {
            int x = location[0] - point[0];
            int y = location[1] - point[1];
            if (x == 0 && y == 0) {
                ans++;
            } else {
                angle.emplace_back(atan2(y, x) * 180 / M_PI);
            }
        }

        sort(angle.begin(), angle.end());

        for(int i = 0, n = angle.size(); i < n; i++) {
            angle.emplace_back(angle[i] + 360);
        }

        int anw = ans;
        for(int i = 0, j = 0; i < angle.size(); i++) {
            while(j < angle.size() &&
                (angle[j] - angle[i] < ang + 1e-9)) {
                j++;
            }
            anw = max(j - i + ans, anw);
        }

        return anw;
    }
};