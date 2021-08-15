// 暴力解法
// Runtime: 8 ms, faster than 40.00% of C++ online submissions for Number of Strings That Appear as Substrings in Word.
// Memory Usage: 9.4 MB, less than 60.00% of C++ online submissions for Number of Strings That Appear as Substrings in Word.
class Solution {
public:
    int numOfStrings(vector<string>& patterns, string word) {

        auto check = [](string pattern, string word) -> bool {
             int m = pattern.size();
             int len = word.size();

             for (int i = 0; i + m <= len; i++) {
                bool flag = true;

                for (int j = 0; j < m; j++) {
                    if (word[i + j] != pattern[j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return flag;
                }
             }

             return false;
        };

        int res = 0;

        for (string pattern : patterns) {
            res += check(pattern, word);
        }

        return res;

    }
};