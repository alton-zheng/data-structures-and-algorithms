class Solution {
public:
    int maxUncrossedLines(vector<int>& nums1, vector<int>& nums2) {

        int n1Len = nums1.size(), n2Len = nums2.size();
        vector<vector<int>> help(n1Len + 1, vector<int>(n2Len + 1));

        for (int i = 1; i <= n1Len; i++) {
            for (int j = 1; j <= n2Len; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    help[i][j] = help[i - 1][j - 1] + 1;
                } else {
                    help[i][j] = max(help[i][j - 1], help[i - 1][j]);
                }
            }
        }

        return help[n1Len][n2Len];
    }
};