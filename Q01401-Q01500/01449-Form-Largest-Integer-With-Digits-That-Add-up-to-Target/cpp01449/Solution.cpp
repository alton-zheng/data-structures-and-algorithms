// Runtime: 4 ms, faster than 100.00% of C++ online submissions for Form Largest Integer With Digits That Add up to Target.
// Memory Usage: 9.1 MB, less than 83.47% of C++ online submissions for Form Largest Integer With Digits That Add up to Target.
class Solution {
public:
    string largestNumber(vector<int>& cost, int target) {

        vector<int> help(target + 1, INT_MIN);
        help[0] = 0;

        for (int c: cost) {
            for (int j = c; j <= target; j++) {
                help[j] = max(help[j], help[j - c] + 1);
            }
        }

        if (help[target] < 0) {
            return "0";
        }

        string res;

        for (int i = 9, j = target; i >= 1; i--) {
            for (int c = cost[i - 1]; j >= c && help[j] == help[j - c] + 1; j -= c) {
                res += '0' + i;
            }
        }

        return res;
    }
};