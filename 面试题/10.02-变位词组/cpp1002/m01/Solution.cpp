// 执行用时： 24 ms , 在所有 C++ 提交中击败了 99.38% 的用户
// 内存消耗： 17.5 MB , 在所有 C++ 提交中击败了 78.59% 的用户
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {

        unordered_map<string, vector<string>> help;

        for (string& str: strs) {
            string key = str;
            sort(key.begin(), key.end());
            help[key].emplace_back(str);
        }
        vector<vector<string>> ans;
        for (auto curList = help.begin(); curList != help.end(); curList++) {
            ans.push_back(curList -> second);
        }
        return ans;
    }
};