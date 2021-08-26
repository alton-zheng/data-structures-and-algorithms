/**
Runtime: 4 ms, faster than 56.06% of C++ online submissions for Height Checker.
Memory Usage: 8.2 MB, less than 68.00% of C++ online submissions for Height Checker.
 */
class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> help(101);

        for (int height: heights) {
            help[height]++;
        }

        int res = 0;
        int idx = 0;
        for (int i = 1; i <= 100; i++) {
            while (help[i] > 0) {
                if (heights[idx++] != i) {
                    res++;
                }
                help[i]--;
            }
        }

        return res;
    }
};