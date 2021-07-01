// 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
// 内存消耗： 35.8 MB , 在所有 Java 提交中击败了 82.69% 的用户
class Solution {
public:
    int numWays(int n, vector<vector<int>>& relation, int k) {
        vector<int> help(n);
        help[0] = 1;

        for (int i = 0; i < k; i++) {

            vector<int> temp(n);
            for (vector<int>& cur: relation) {
                int src = cur[0], dst = cur[1];
                temp[dst] += help[src];
            }
            help = temp;
        }

        return help[n - 1];
    }
};