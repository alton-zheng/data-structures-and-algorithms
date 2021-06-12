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
 * Runtime: 8 ms, faster than 99.77% of C++ online submissions for Kth Smallest Element in a BST.
   Memory Usage: 24.2 MB, less than 58.17% of C++ online submissions for Kth Smallest Element in a BST.
 */
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {

        stack<TreeNode*> stk;
        while (true) {

            while (root != nullptr) {
                stk.emplace(root);
                root = root -> left;
            }

            root = stk.top();
            stk.pop();
            if (--k == 0){
                return root -> val;
            }

            root = root -> right;
        }
    }
};