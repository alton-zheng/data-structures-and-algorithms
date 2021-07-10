/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };

 Runtime: 8 ms, faster than 42.60% of C++ online submissions for Binary Tree Level Order Traversal II.
 Memory Usage: 12.5 MB, less than 82.99% of C++ online submissions for Binary Tree Level Order Traversal II.
 */
class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> res;

        // 树为空时，返回空 list
        if (!root){
            return res;
        }

        queue<TreeNode*> q;

        q.push(root);

        while (!q.empty()) {
            vector<int> level;
            int size = q.size();

            // 遍历当前层级所有节点，将节点值添加到 level
            for (int i = 0; i < size; i++) {
                auto node = q.front();
                q.pop();
                level.push_back(node -> val);
                TreeNode* left = node -> left;
                TreeNode* right = node -> right;

                // left right 不为空， 才将对应节点添加到 queue 中
                if (left != nullptr) {
                    q.push(left);
                }

                if (right != nullptr) {
                    q.push(right);
                }
            }

            // 这里是关键，保证 level, 从底到上存储
            res.push_back(level);

        }

        reverse(res.begin(), res.end());
        return res;
    }
};