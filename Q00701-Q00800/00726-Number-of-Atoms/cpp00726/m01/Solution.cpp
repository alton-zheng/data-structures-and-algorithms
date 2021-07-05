// Runtime: 4 ms, faster than 66.86% of C++ online submissions for Number of Atoms.
// Memory Usage: 7 MB, less than 48.85% of C++ online submissions for Number of Atoms.
class Solution {
public:
    string countOfAtoms(string formula) {

        int i = 0, n = formula.length();

        auto parseAtom = [&]() -> string {
            string atom;

            // 扫描首字母
            atom += formula[i++];

            while (i < n && islower(formula[i])) {
                atom += formula[i++];
            }
            return atom;
        };

        auto parseNum = [&]() -> int {

            // 不是数字，统计数量为 1
            if (i == n || !isdigit(formula[i])) {
                return 1;
            }

            int num = 0;

            // 扫描数字
            while (i < n && isdigit(formula[i])) {
                num = num * 10 + formula[i++] - '0';
            }
            return num;
        };

        stack<unordered_map<string, int>> stk;
        stk.push({});
        while (i < n) {
            char ch = formula[i];

            // 简单点理解， 有多少组 "()", 就会在 stk 压入多少个 map. 然后根据每一种场景从栈顶解到栈低，直到最后一个字符为止
            if (ch == '(') {

                i++;
                // 将空的 hash 表压入栈， 准备统计括号内的原子数量
                stk.push({});

            } else if (ch == ')') {
                i++;
                // 括号右侧的数字
                int num = parseNum();
                auto atomNum = stk.top();
                // 弹出括号内的原子数量
                stk.pop();

                for (auto &[atom, v]: atomNum) {
                    stk.top()[atom] += v * num;
                }
            } else {
                string atom = parseAtom();
                int num = parseNum();

                // 统计原子数量
                stk.top()[atom] += num;
            }
        }

        auto &atomNum = stk.top();
        vector<pair<string, int>> pairs;

        for (auto &[atom, v] : atomNum) {
            pairs.emplace_back(atom, v);
        }

        sort(pairs.begin(), pairs.end());

        string ans;

        for (auto & p: pairs) {
            ans += p.first;
            if (p.second > 1) {
                ans += to_string(p.second);
            }
        }

        return ans;


    }
};