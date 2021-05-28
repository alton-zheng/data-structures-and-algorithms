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
 * Runtime: 4 ms, faster than 92.67% of C++ online submissions for Maximum Depth of Binary Tree.
 * Memory Usage: 19 MB, less than 11.61% of C++ online submissions for Maximum Depth of Binary Tree.
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {

 if (!root) {
            return 0;
        }

        return getMaxDepth(root, 1);

    }

private:
 int getMaxDepth(TreeNode* node, int depth) {

        int l = depth;
        if (node -> left){
            l = getMaxDepth(node -> left, depth + 1);
        }

        int r = depth;
        if (node -> right) {
            r = getMaxDepth(node -> right, depth + 1);
        }

        return max(l, r);

    }

 };