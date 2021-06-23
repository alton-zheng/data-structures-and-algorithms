// 执行用时： 44 ms , 在所有 C++ 提交中击败了 74.48% 的用户
// 内存消耗： 19.9 MB , 在所有 C++ 提交中击败了 76.20% 的用户
class Solution {

private:
    vector<string> res;
    vector<int> visit;
    void backtrack(const string& s, int i, int n, string& perm) {
        if (i == n) {
            res.push_back(perm);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (visit[j] || (j > 0 && !visit[j - 1] && s[j - 1] == s[j])) {
                continue;
            }
            visit[j] = true;
            perm.push_back(s[j]);
            backtrack(s, i + 1, n, perm);
            perm.pop_back();
            visit[j] = false;
        }
    }

public:
    vector<string> permutation(string s) {
        int n = s.size();
        visit.resize(n);
        sort(s.begin(), s.end());
        string perm;
        backtrack(s, 0, n, perm);
        return res;
    }
};