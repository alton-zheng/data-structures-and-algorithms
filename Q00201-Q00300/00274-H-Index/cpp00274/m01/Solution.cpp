// Runtime: 4 ms, faster than 56.39% of C++ online submissions for H-Index.
// Memory Usage: 8.7 MB, less than 16.27% of C++ online submissions for H-Index.
class Solution {
public:
    int hIndex(vector<int>& citations) {

        int len = citations.size();
        vector<int> help(len + 1);

        for (int c: citations) {
            if (c < len) {
                help[c]++;
            } else {
                help[len]++;
            }
        }

        for (int h = len, total = 0; h >= 0; h--) {

            if (help[h] > 0) {
                total += help[h];
            }

            if (total >= h) {
                return h;
            }

        }

        return 0;
    }
};