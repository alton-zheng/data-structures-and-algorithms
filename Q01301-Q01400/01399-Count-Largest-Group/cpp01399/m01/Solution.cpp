// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Count Largest Group.
// Memory Usage: 7 MB, less than 8.25% of C++ online submissions for Count Largest Group.
class Solution {
public:
    int countLargestGroup(int n) {
        int m = 0;
        if (n < 19) {
            m = 9;
        } else if (n < 199) {
            m = 18;
        } else if (n < 1999){
            m = 27;
        } else if (n <= 10000) {
            m = 36;
        }

        int mCount = 0;
        vector<int> help(m + 1);
        vector<int> dp(n + 1);
        for (int i = 1; i <= n; i++) {

            dp[i] = dp[i / 10] + i % 10;
            help[dp[i]]++;
            mCount = max(mCount, help[dp[i]]);
        }
        int res = 0;

        for (int i = 1; i <= m; i++) {
            if (help[i] == mCount) {
                res++;
            }
        }

        return res;
    }
};