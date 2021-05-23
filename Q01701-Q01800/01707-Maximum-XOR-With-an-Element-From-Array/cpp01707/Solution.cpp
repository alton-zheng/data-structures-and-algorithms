/**
 * Time Complexity : O(NlogN+QlogQ+(N+Q)⋅L) 其中 N 是数组 nums 的长度，Q 是数组 \textit{queries}queries 的长度，
 * L 是 nums 中的每个元素的二进制表示的长度，算法中固定 L=30。排序 nums 的时间复杂度为 O(NlogN)，排序 queries 的时间复杂度为 O(QlogQ)，
 * 每次插入和查询的时间复杂度均为 O(L)，因此总的时间复杂度为 O(NlogN+QlogQ+(N+Q)⋅L)。
 * Space Complexity: O(Q+N⋅L)。我们需要 O(Q) 的空间来存储每个查询在排序前的 queries 中的位置，且 nums 中的每个元素至多需要 O(L) 个字典树节点来存储，O(Q+N⋅L)。
 */
class Trie {
public:
    const int L = 30;

    Trie* children[2] = {};

    void insert(int val) {
        Trie* node = this;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node->children[bit] == nullptr) {
                node->children[bit] = new Trie();
            }
            node = node->children[bit];
        }
    }

    int getMaxXor(int val) {
        int ans = 0;
        Trie* node = this;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node->children[bit ^ 1] != nullptr) {
                ans |= 1 << i;
                bit ^= 1;
            }
            node = node->children[bit];
        }
        return ans;
    }
};

class Solution {
public:
    vector<int> maximizeXor(vector<int> &nums, vector<vector<int>> &queries) {
        sort(nums.begin(), nums.end());
        int numQ = queries.size();
        for (int i = 0; i < numQ; ++i) {
            queries[i].push_back(i);
        }
        sort(queries.begin(), queries.end(), [](auto &x, auto &y) { return x[1] < y[1]; });

        vector<int> ans(numQ);
        Trie* t = new Trie();
        int idx = 0, n = nums.size();
        for (auto &q : queries) {
            int x = q[0], m = q[1], qid = q[2];
            while (idx < n && nums[idx] <= m) {
                t->insert(nums[idx]);
                ++idx;
            }
            if (idx == 0) { // 字典树为空
                ans[qid] = -1;
            } else {
                ans[qid] = t->getMaxXor(x);
            }
        }
        return ans;
    }
};