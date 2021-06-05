// Runtime: 20 ms, faster than 25.29% of C++ online submissions for Relative Ranks.
// Memory Usage: 10.9 MB, less than 58.47% of C++ online submissions for Relative Ranks.
class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {

        int len = score.size();
        int m = 0;
        for (int i = 0; i < len; i++) {
            m = m >= score[i] ? m : score[i];
        }

        vector<int> help(m + 1);

        for (int i = 0; i < len; i++) {
            help[score[i]] = i + 1;
        }

        vector<string> res(len);
        int rank = 1;
        for (int i = help.size() - 1; i >= 0; i--) {
            if (help[i] != 0) {
                switch(rank) {
                    case 1:
                        res[help[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        res[help[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        res[help[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        res[help[i] - 1] = to_string(rank);

                }
                rank++;
            }
        }

        return res;
    }
};