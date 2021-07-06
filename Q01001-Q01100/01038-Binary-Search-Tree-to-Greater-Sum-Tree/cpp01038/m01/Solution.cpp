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
 Runtime: 4 ms, faster than 56.78% of C++ online submissions for Binary Search Tree to Greater Sum Tree.
 Memory Usage: 8.1 MB, less than 50.58% of C++ online submissions for Binary Search Tree to Greater Sum Tree.
 */
class Solution {
private:
    int m = 0;
public:
    TreeNode* bstToGst(TreeNode* root) {
        if (root == nullptr) {
            return nullptr;
        }

        root -> right = bstToGst(root -> right);
        root -> val += m;
        m = root -> val;
        root -> left = bstToGst(root -> left);
        return root;
    }
};