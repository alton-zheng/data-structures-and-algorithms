// Runtime: 148 ms, faster than 89.99% of C++ online submissions for Find the Town Judge.
// Memory Usage: 60.7 MB, less than 89.60% of C++ online submissions for Find the Town Judge.
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {

        vector<int> help(n + 1);

        for (vector<int>& t: trust) {
            help[t[0]]--;
            help[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (help[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
};