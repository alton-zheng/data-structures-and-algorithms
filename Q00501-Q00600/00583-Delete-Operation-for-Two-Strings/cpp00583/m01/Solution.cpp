class Solution {
public:
    int minDistance(string word1, string word2) {
        int w1L = word1.size(), w2L = word2.size();

        vector<vector<int>> help(w1L + 1, vector<int>(w2L + 1,0));

        for (int i = 1; i <= w1L; i++) {
            help[i][0] = i;
        }

        for (int j = 1; j <= w2L; j++) {
            help[0][j] = j;
        }

        for (int i = 1; i <= w1L; i++) {
            char c1 = word1[i - 1];
            for (int j = 1; j <= w2L; j++) {
                char c2 = word2[j - 1];
                if (c1 == c2) {
                    help[i][j] = help[i - 1][j - 1];
                } else {
                    help[i][j] = min(help[i - 1][j], help[i][j - 1]) + 1;
                }
            }
        }

        return help[w1L][w2L];
    }
};