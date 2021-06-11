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

 Runtime: 32 ms, faster than 7.46% of C++ online submissions for Trim a Binary Search Tree.
 Memory Usage: 23.9 MB, less than 70.45% of C++ online submissions for Trim a Binary Search Tree.

 Time Complexity: O(n)
 Space Complexity: O(n)
 */
class Solution {
public:
    TreeNode* trimBST(TreeNode* root, int low, int high) {

        if (root == nullptr) {
            return nullptr;
        }

        if (root -> val > high) {
            return trimBST(root -> left, low, high);
        }

        if (root -> val < low) {
            return trimBST(root -> right, low, high);
        }

        root -> left = trimBST(root -> left, low, high);
        root -> right = trimBST(root -> right, low, high);

        return root;
    }
};