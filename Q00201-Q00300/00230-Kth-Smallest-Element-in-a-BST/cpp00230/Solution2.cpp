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
 * Runtime: 16 ms, faster than 81.47% of C++ online submissions for Kth Smallest Element in a BST.
 * Memory Usage: 24 MB, less than 85.57% of C++ online submissions for Kth Smallest Element in a BST.
 */
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        kth = k;
        inorder(root);
        return res;
    }

private:
    int res = -1;
    int kth = -1;
    void inorder(TreeNode* node) {

        if (node == nullptr || kth < 0) {
            return;
        }

        inorder(node -> left);

        if (--kth == 0) {
            res = node -> val;
            return;
        }

        inorder(node -> right);

    }
};