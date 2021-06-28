// Runtime: 84 ms, faster than 15.98% of C++ online submissions for Count the Number of Consistent Strings.
// Memory Usage: 30.1 MB, less than 53.61% of C++ online submissions for Count the Number of Consistent Strings.
class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        int num = 0;
        for (int i = 0; i < words.size(); i++) {
            int n = 0;
            for (int j = 0; j < words[i].size(); j++) {

                for (char c: allowed) {
                    if (c == words[i][j]) {
                        n++;
                        break;
                    }
                }

            }
            if (n == words[i].size()) {
                num++;
            }
        }
        return num;
    }
};