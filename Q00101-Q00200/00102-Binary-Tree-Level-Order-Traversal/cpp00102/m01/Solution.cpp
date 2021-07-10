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

bfs

 Runtime: 0 ms, faster than 100.00% of C++ online submissions for Binary Tree Level Order Traversal.
 Memory Usage: 12.6 MB, less than 57.59% of C++ online submissions for Binary Tree Level Order Traversal.
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
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

        return res;
    }
};