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
 Runtime: 0 ms, faster than 100.00% of C++ online submissions for Minimum Distance Between BST Nodes.
 Memory Usage: 9.8 MB, less than 10.34% of C++ online submissions for Minimum Distance Between BST Nodes.
 */
class Solution {
private:
    int res = INT_MAX;
    int pre = -1;
    void dfs(TreeNode* node) {
        if (node == nullptr) {
            return;
        }

        dfs(node -> left);

        if (pre == -1) {
            pre = node -> val;
        } else {
            res = min(res, node -> val - pre);
            pre = node -> val;
        }

        dfs (node -> right);
    }

public:
    int minDiffInBST(TreeNode* root) {
        dfs(root);
        return res;
    }
};