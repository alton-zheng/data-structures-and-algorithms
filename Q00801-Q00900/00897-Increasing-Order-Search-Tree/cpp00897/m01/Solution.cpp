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
 Runtime: 0 ms, faster than 100.00% of C++ online submissions for Increasing Order Search Tree.
 Memory Usage: 8 MB, less than 42.91% of C++ online submissions for Increasing Order Search Tree.

 Time Complexity : O(N)
 Space Complexity :O(N)
 */
class Solution {

private:
    TreeNode* pre = new TreeNode(-1);
    TreeNode* temp = pre;

public:
    TreeNode* increasingBST(TreeNode* root) {
        if (root == nullptr) {
            return nullptr;
        }

        increasingBST(root -> left);
        temp -> right = new TreeNode(root -> val);
        temp = temp -> right;
        increasingBST(root -> right);

        return pre -> right;

    }

};