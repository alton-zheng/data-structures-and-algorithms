class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
       vector<int> help(51);

        for (int i = 0; i < ranges.size(); i++) {

            int l = ranges[i][0], r = ranges[i][1];

            if (left > right) {
                return true;
            }

            if (l <= left && r >= left) {
                left = r + 1;
                continue;
            }

            if (l <= right && r >= right) {
                right = l - 1;
                continue;
            }


            for (int j = l; j <= r; j++) {
                help[j]++;
            }
        }

        for(int i = left; i <= right; i++) {
            if (help[i] <= 0) {
                return false;
            }
        }

        return true;
    }
};