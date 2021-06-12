// Runtime: 24 ms, faster than 72.58% of C++ online submissions for Form Largest Integer With Digits That Add up to Target.
// Memory Usage: 19.4 MB, less than 72.18% of C++ online submissions for Form Largest Integer With Digits That Add up to Target.

class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {

        vector<vector<int>> help(10, vector<int>(target + 1, INT_MIN));
        vector<vector<int>> from(10, vector<int>(target + 1));

        help[0][0] = 0;

        for (int i = 0; i < 9; i++) {
            int c = cost[i];

            for (int j = 0; j <= target; j++) {

                if (j < c || help[i][j] > help[i + 1][j -c] + 1) {
                    help[i + 1][j] = help[i][j];
                    from[i + 1][j] = j;
                } else {
                    help[i + 1][j] = help[i + 1][j - c] + 1;
                    from[i + 1][j] = j - c;
                }
            }
        }


        if (help[9][target] < 0) {
            return "0";
        }

        int i = 9, j = target;
        string res;

        while (i > 0) {

            if (j == from[i][j]) {
                i--;
            } else {
                res += '0' + i;
                j = from[i][j];
            }
        }

        return res;
    }
};