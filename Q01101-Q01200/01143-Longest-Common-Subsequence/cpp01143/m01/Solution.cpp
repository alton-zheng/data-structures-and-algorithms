// Runtime: 20 ms, faster than 55.11% of C++ online submissions for Longest Common Subsequence.
// Memory Usage: 13 MB, less than 39.76% of C++ online submissions for Longest Common Subsequence.
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int t1Len = text1.size(), t2Len = text2.size();
        vector<vector<int>> dp(t1Len, vector<int>(t2Len));

        for (int i = 1; i <= t1Len; i++) {
            for (int j = 1; j <= t2Len; j++) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }

        return dp[t1Len][t2Len];
    }
};