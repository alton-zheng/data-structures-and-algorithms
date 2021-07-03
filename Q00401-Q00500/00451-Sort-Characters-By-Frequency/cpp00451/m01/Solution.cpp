// Runtime: 8 ms, faster than 98.53% of C++ online submissions for Sort Characters By Frequency.
// Memory Usage: 8.6 MB, less than 33.84% of C++ online submissions for Sort Characters By Frequency.
class Solution {
public:
    string frequencySort(string s) {
        // 122 为 z char 编码
        vector<int> help(123);

        for (char c: s) {
            help[c]++;
        }

        vector<pair<int, int>> l;
        for (int i = 0; i < 123; i++) {
            // 排除未出现过的字符，减少 queue 的排序消耗
            if (help[i] > 0) {
                l.emplace_back(pair(i, help[i]));
            }

        }

        sort(l.begin(), l.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
                return a.second > b.second;
            });

        string res;

        // 按频率高到低从 list 中取出并写入到结果集中
        for (auto &[c, time] : l) {

            for (int i =0 ; i < time;i++) {
                res.push_back(c);
            }
        }

        return res;
    }
};