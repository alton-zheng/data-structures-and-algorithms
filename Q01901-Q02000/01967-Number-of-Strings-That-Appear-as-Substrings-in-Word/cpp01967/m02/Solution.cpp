// KMP 算法
class Solution {
public:
    int numOfStrings(vector<string>& patterns, string word) {
        auto check = [](const string& pattern, const string& word) -> bool{
            int m = pattern.size();
            int n = word.size();
            // 生成 pattern 的前缀数组
            vector<int> pi(m);
            for (int i = 1, j = 0; i < m; i++){
                while (j > 0 && pattern[i] != pattern[j]){
                    j = pi[j - 1];
                }
                if (pattern[i] == pattern[j]){
                    ++j;
                }
                pi[i] = j;
            }
            // 利用前缀数组进行匹配
            for (int i = 0, j = 0; i < n; i++){
                while (j > 0 && word[i] != pattern[j]){
                    j = pi[j - 1];
                }
                if (word[i] == pattern[j]){
                    ++j;
                }
                if (j == m){
                    return true;
                }
            }
            return false;
        };

        int res = 0;
        for (const string& pattern : patterns){
            res += check(pattern, word);
        }
        return res;
    }
};