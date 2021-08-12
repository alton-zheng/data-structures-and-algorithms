// Runtime: 104 ms, faster than 32.56% of C++ online submissions for Longest Palindromic Subsequence.
// Memory Usage: 73 MB, less than 29.81% of C++ online submissions for Longest Palindromic Subsequence.
class Solution {
public:
    int longestPalindromeSubseq(string s) {

        int len = s.size();

        vector<vector<int>> dp(len, vector<int>(len));

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;

            char x = s[i];

            for (int j = i + 1; j < len; j++) {
                char y = s[j];

                dp[i][j] = x == y ? dp[i + 1][j - 1] + 2 : max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][len - 1];
    }
};