// 执行用时： 16 ms , 在所有 C++ 提交中击败了 98.67% 的用户
// 内存消耗： 17.1 MB , 在所有 C++ 提交中击败了 96.84% 的用户
class Solution {
public:
    bool nextPermutation(string& s) {
        int i = s.size() - 2;
        while (i >= 0 && s[i] >= s[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = s.size() - 1;
        while (j >= 0 && s[i] >= s[j]) {
            j--;
        }
        swap(s[i], s[j]);
        reverse(s.begin() + i + 1, s.end());
        return true;
    }

    vector<string> permutation(string s) {
        vector<string> res;
        sort(s.begin(), s.end());
        do {
            res.push_back(s);
        } while (nextPermutation(s));
        return res;
    }
};