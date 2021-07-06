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

 Runtime: 40 ms, faster than 46.53% of C++ online submissions for Convert BST to Greater Tree.
 Memory Usage: 33.5 MB, less than 19.10% of C++ online submissions for Convert BST to Greater Tree.


 */
class Solution {
private:
    int m = 0;
public:
    TreeNode* convertBST(TreeNode* root) {
        if (root  == nullptr) {
            return root;
        }

        root -> right = convertBST(root -> right);
        root -> val += m;
        m = root -> val;
        root -> left = convertBST(root -> left);

        return root;
    }
};