class Solution {
public:
    int uniqueLetterString(string s) {
        unordered_map<char, vector<int>> help;

        int len = s.size();

        for (int i = 0; i < len; i++) {
            help[s[i]].emplace_back(i);
        }


        int res = 0;
        for (auto &&[_, arr]: help) {
            arr.insert(arr.begin(), -1);
            arr.emplace_back(len);

            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr[i] - arr[i - 1]) * (arr[i + 1] - arr[i]);
            }
        }

        return res;
    }
};